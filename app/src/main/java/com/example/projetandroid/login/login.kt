package com.example.projetandroid.login

import android.text.Layout.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.projetandroid.ui.theme.Typography

@Composable
fun loginPage(){
    var login by remember { mutableStateOf("") }
    Row(horizontalArrangement = Arrangement.Center) {
        Text(text = "Te revoilà ! 🔥",
            color = Color.Black,
            style = Typography.h1,
            textAlign = TextAlign.Center
        )
    }
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 50.dp)) {
        Text(text = "Reviens vite pour profiter \n des bons plans",
            color = Color.Black,
            style = Typography.h2,
            textAlign = TextAlign.Center
        )
    }
    //INPUTS

    Row(modifier = Modifier
        .padding(top = 100.dp)) {
    TextField(value = login,
        onValueChange = {login = it},
        //label = { Text(text = "Login")},
        placeholder = { Text(text = "Email")},
        modifier = Modifier.fillMaxWidth()
        )
    }
}