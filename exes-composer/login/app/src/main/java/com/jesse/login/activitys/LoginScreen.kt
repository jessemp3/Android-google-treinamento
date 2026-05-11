package com.jesse.login.activitys

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.login.R


@Preview
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val buttonEnabled = email.isNotBlank() && password.isNotBlank()

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login",
            modifier = Modifier.padding(bottom = 32.dp),
            color = Color.Black,
            fontSize = 32.sp
        )


        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Digite seu Email:") },
            modifier = Modifier.padding(bottom = 16.dp)
                .size(340.dp, 50.dp)
                .clip(RoundedCornerShape(30.dp)).border(1.dp, Color.Black, RoundedCornerShape(30.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Black,
                disabledIndicatorColor = Color.Black,
                cursorColor = Color.Black,
            )
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Digite sua senha:") },
            modifier = Modifier.padding(bottom = 16.dp)
                .size(340.dp, 50.dp)
                .clip(RoundedCornerShape(30.dp)).border(1.dp, Color.Black, RoundedCornerShape(30.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Black,
                disabledIndicatorColor = Color.Black,
                cursorColor = Color.Black,
            )
        )

        Text(
            "Esqueci minha senha",
            modifier = Modifier.padding(bottom = 32.dp),
            color = Color.Blue,
            fontSize = 12.sp
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(R.drawable.icons8_google),
                contentDescription = null,
                modifier = Modifier.size(34.dp)
            )

            Spacer(Modifier.width(16.dp))

            Image(
                painter = painterResource(R.drawable.icons8_apple),
                contentDescription = null,
                modifier = Modifier.size(34.dp)
            )
        }

        Button(
            onClick = {},
            enabled = buttonEnabled,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.padding(top = 32.dp)
                .size(300.dp, 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.White
            )
        ) {
            Text(
                "Entrar",
                fontSize = 16.sp,
                color = if(buttonEnabled) Color.White else Color.Gray
            )
        }


    }
}
