package com.jesse.imc.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.imc.datasource.Calculation
import com.jesse.imc.ui.theme.Blue
import com.jesse.imc.ui.theme.Red
import com.jesse.imc.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    var tfError by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("IMC: 24.1 \nPeso Normal") }





    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Calculadora de IMC")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Blue,
                    titleContentColor = White
                )
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .background(White)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Altura (Cm)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp, 100.dp, 0.dp , 0.dp )
                )

                Text(
                    "Peso (Kg)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 100.dp, 20.dp , 0.dp )
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = height,
                    onValueChange = {
                        if(it.length <= 3){
                            height = it
                        }
                    },
                    label = {
                        Text(text = "Ex: 180")
                    },
                    modifier = Modifier.fillMaxWidth(0.4f)
                        .padding(20.dp, 0.dp, 0.dp, 20.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword
                    ),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White,
                        focusedContainerColor = White,

                        focusedLabelColor = Blue,
                        focusedIndicatorColor = Blue,
//                        errorIndicatorColor = Red,

                        cursorColor = Blue
                    ),
                    isError = tfError
                )

                OutlinedTextField(
                    value = weight,
                    onValueChange = {
                        if(it.length <= 7){
                            weight = it
                        }
                    },
                    label = {
                        Text(text = "Ex: 60.40")
                    },
                    modifier = Modifier.fillMaxWidth(0.7f)
                        .padding(0.dp, 0.dp, 20.dp, 20.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = White,
                        focusedContainerColor = White,

                        focusedLabelColor = Blue,
                        focusedIndicatorColor = Blue,
//                        errorIndicatorColor = Red,

                        cursorColor = Blue
                    ),
                    isError = tfError
                )
            }

            Button(
                onClick = {
                    Calculation.ImcCalculate(height, weight){
                            response, error ->
                        result = response
                        tfError = error
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                modifier = Modifier.fillMaxWidth()
                    .height(110.dp)
                    .padding(30.dp)
            ) {
                Text(
                    text = "Calcular",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = result,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Blue,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomePreview(){
    Home()
}