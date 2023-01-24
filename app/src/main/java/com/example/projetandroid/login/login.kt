package com.example.projetandroid.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetandroid.ui.theme.Typography
import com.example.projetandroid.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun loginPage(navController: NavController){

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var auth: FirebaseAuth = Firebase.auth
    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .background(BackgroundColor)
            .padding(top = 80.dp)) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = "Te revoila 🔥",
                color = Color.Black,
                style = Typography.h1,
                textAlign = TextAlign.Center
            )
        }
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 13.dp)) {
            Text(text = "Reviens vite pour profiter \n des bons plans",
                color = Color.Black,
                style = Typography.h2,
                textAlign = TextAlign.Center
            )
        }
        //INPUTS

        Row(modifier = Modifier
            .padding(top = 45.dp)) {
            Input(value = login, placeholder = "Ton adresse e-mail", onValueChange = {newText -> login = newText})
        }
        Row(modifier = Modifier
            .padding(top = 17.dp)) {
            Input(value = password, placeholder = "Ton mot de passe",
                onValueChange = {newText -> password = newText}, true)
        }
        //Forgot password
        Row(modifier = Modifier
            .padding(top = 22.dp, end = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End) {
            Text(text = "Mot de passe oublié ?",
                color = TinyText,
                textAlign = TextAlign.End,
                style = Typography.body1,
            modifier = Modifier.clickable {  })
        }
        //Button connect
        Row(modifier = Modifier
            .padding(top = 43.dp)) {
            Button(onClick = {
                auth.signInWithEmailAndPassword(login, password)
                    .addOnCompleteListener{ task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("sign", "signInWithEmail:success")
                            val user = auth.currentUser
//                                updateUI(user)
                            navController.navigate("home")
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("sing", "signInWithEmail:failure", task.exception)
                            Toast.makeText(context, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
//                                updateUI(null)
                        }
                    }
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .width(327.dp)
                    .height(56.dp)
            )

            {
                Text(text = "SE CONNECTER",color = Color.White, style = Typography.body2)
            }
        }
        //Sing in
        Row(verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 37.dp)){
            Text(text = "Pas encore inscrit ? ", style = Typography.body1, color = TinyText)
            Text(
                text = "Aller viens !",
                color = ClickableText,
                style = Typography.body1,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                })
        }
    }
}