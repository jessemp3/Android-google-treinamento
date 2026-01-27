package com.jesse.imc.datasource


object Calculation {
    fun ImcCalculate(height: String, weight: String , response: (String , Boolean) -> Unit){
        if(height.isNotEmpty() && weight.isNotEmpty()) {
            val heightDouble = height.toDoubleOrNull()
            val weightDouble = weight.replace(",", ".").toDoubleOrNull()

            if (heightDouble != null && weightDouble != null) {
                val imc = weightDouble / (heightDouble / 100 * heightDouble / 100)



                val imcResult = when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc in 18.5 .. 24.9 -> "Peso normal"
                    imc in 25.0..29.9 -> "sobrepeso"
                    imc in  30.0 .. 34.9 -> "Obesidade grau 1"
                    imc in 35.0 .. 39.9 -> "Obesidade grau 2"
                    else -> "Obesidade grau 3"
                }

                response("IMC: ${"%.2f".format(imc)}", false)

            }
        }else{
            response("Preencha todos os campos",true)
        }
    }

}