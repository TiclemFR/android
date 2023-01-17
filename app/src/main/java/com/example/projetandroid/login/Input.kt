package com.example.projetandroid.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.projetandroid.ui.theme.*

@Composable
fun Input(value:String, placeholder: String, onValueChange: (String) -> Unit, password:Boolean = false){
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    TextField(value = value,
        onValueChange = onValueChange,
        //label = { Text(text = "Login")},
        placeholder = { Text(text = placeholder) },
        modifier = Modifier
            .padding(top = 10.dp)
            .width(screenWidth - 20.dp),
        shape = RoundedCornerShape(20),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = BackgroundColorInput,
            placeholderColor = PlaceHolderColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None,
    )
}