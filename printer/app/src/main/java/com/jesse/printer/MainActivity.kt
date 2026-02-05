package com.jesse.printer

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.jesse.printer.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import androidx.core.graphics.scale
import androidx.core.graphics.createBitmap

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // Use lazy para garantir que o sistema já está pronto quando acessar o service
    private val bluetoothAdapter: BluetoothAdapter? by lazy {
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter
    }

    // Registrar o pedido de permissão (Obrigatório Android 12+)
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            iniciarFluxoImpressao()
        } else {
            Toast.makeText(this, "Permissão Bluetooth negada", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {
            verificarPermissaoEImprimir()
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun verificarPermissaoEImprimir() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
        } else {
            iniciarFluxoImpressao()
        }
    }

    private fun iniciarFluxoImpressao() {
        lifecycleScope.launch(Dispatchers.IO) {
            // 1. Verificação explícita de permissão para calar o erro de compilação
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Se não tiver permissão, volta para a Main Thread para avisar o usuário
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Sem permissão de Bluetooth", Toast.LENGTH_SHORT).show()
                }
                return@launch
            }

            // 2. Agora o acesso é seguro
            val pairedDevices = bluetoothAdapter?.bondedDevices

            pairedDevices?.forEach { d ->
                // d.name também exige a permissão que checamos acima
                println("Dispositivo pareado encontrado: ${d.name} -> ${d.address}")
            }

            val device = getImpressoraPareada()

            if (device != null) {
                conectarEImprimir(device)
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "MPT-II não encontrada!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    // Adicione a lógica de conexão aqui ou na sua classe Printer
    private fun conectarEImprimir(device: BluetoothDevice) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) return

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.logo)
        val scaledBitmap = bitmap.scale(400, 300, false)

        var socket: BluetoothSocket? = null
        val uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

        try {
            // Tentativa 1: Método Padrão
            socket = device.createRfcommSocketToServiceRecord(uuid)
            socket.connect()
        } catch (e: Exception) {
            e.printStackTrace()
            // Tentativa 2: "Insecure" Reflection (O segredo para impressoras baratas)
            try {
                val m = device.javaClass.getMethod("createRfcommSocket", Int::class.javaPrimitiveType)
                socket = m.invoke(device, 1) as BluetoothSocket
                socket.connect()
            } catch (e2: Exception) {
                e2.printStackTrace()
                socket = null
            }
        }

        // Se conseguiu conectar em algum dos métodos acima
        socket?.let { s ->
            try {
                val out = s.outputStream

                // Comandos de Teste
                val init = byteArrayOf(0x1B, 0x40)
                val texto = "Teste Printer\n\n\n".toByteArray()
                val imageBytes = getPrintableBitmap(scaledBitmap)
                val alinharCentro = byteArrayOf(0x1B, 0x61, 0x01)

                out.write(init)
                out.write(alinharCentro)
                out.write(imageBytes)
//                out.write(texto)
                out.flush()

                // Dá um tempinho para a impressora processar antes de fechar
                Thread.sleep(1000)
                s.close()
                Log.d("PRINTER", "Socket Fechado")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    fun getImpressoraPareada(): BluetoothDevice? {
        if (bluetoothAdapter?.isEnabled == false) return null

        val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices

        // Vamos buscar especificamente pelo seu modelo ou por partes do nome
        return pairedDevices?.find { device ->
            val nome = device.name ?: ""
            nome.contains("MPT-II", ignoreCase = true) ||
                    nome.contains("3010") ||
                    nome.contains("MPT", ignoreCase = true)
        }
    }

    fun decodeBitmap(bmp: Bitmap): ByteArray {
        val width = bmp.width
        val height = bmp.height
        val pixels = IntArray(width * height)
        bmp.getPixels(pixels, 0, width, 0, 0, width, height)

        val res = mutableListOf<Byte>()
        // Comando para densidade de bits (ESC * m nL nH)
        // m = 33 (24-dot double density), nL e nH definem a largura
        val nL = (width % 256).toByte()
        val nH = (width / 256).toByte()

        var row = 0
        while (row < height) {
            res.add(0x1B)
            res.add(0x2A)
            res.add(33) // modo 24-dot
            res.add(nL)
            res.add(nH)

            for (col in 0 until width) {
                for (k in 0 until 3) { // 24 bits verticalmente (3 bytes)
                    var slice: Byte = 0
                    for (bit in 0 until 8) {
                        val y = row + k * 8 + bit
                        if (y < height) {
                            val p = pixels[y * width + col]
                            val gray = (0.299 * (p shr 16 and 0xFF) + 0.587 * (p shr 8 and 0xFF) + 0.114 * (p and 0xFF))
                            if (gray < 60) {
                                slice = (slice.toInt() or (1 shl (7 - bit))).toByte()
                            }
                        }
                    }
                    res.add(slice)
                }
            }
            res.add(0x0A) // Quebra de linha
            row += 24
        }
        return res.toByteArray()
    }

    fun getPrintableBitmap(bitmap: Bitmap): ByteArray {
        val width = bitmap.width
        val height = bitmap.height
        val bwBitmap = createBitmap(width, height, Bitmap.Config.RGB_565)
        val canvas = Canvas(bwBitmap)
        val paint = Paint()

        // Filtro para garantir que cores virem P&B bem definido
        val cm = ColorMatrix()
        cm.setSaturation(0f)
        paint.colorFilter = ColorMatrixColorFilter(cm)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        // Aqui você converteria para os bytes como fizemos antes
        // Mas antes, garanta que o fundo é BRANCO:
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.DST_OVER)

        return decodeBitmap(bwBitmap) // chama a função anterior
    }
}