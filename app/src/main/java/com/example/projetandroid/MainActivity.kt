package com.example.projetandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetandroid.login.loginPage
import com.example.projetandroid.ui.theme.*
import connectPage

class MainActivity : ComponentActivity() {
    lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetAndroidTheme {
                navController = rememberNavController()
                NavHost(navController = navController as NavHostController, startDestination = "register"){
                    composable("register"){connectPage(navController)}
                    composable("login"){loginPage(navController)}
                }
//                connectPage()
            }
        }
    }
}