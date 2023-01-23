package com.example.projetandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetandroid.BonPlan.BonPlan
import com.example.projetandroid.login.loginPage
import com.example.projetandroid.onBoarding.OnBoarding
import com.example.projetandroid.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import connectPage

class MainActivity : ComponentActivity() {
    lateinit var navController:NavController
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetAndroidTheme {
                navController = rememberNavController()
                NavHost(navController = navController as NavHostController,
                    startDestination = "onBoarding"){
                    composable("register"){connectPage(navController)}
                    composable("login"){loginPage(navController)}
                    composable("add"){ BonPlan(navController = navController)}
                    composable("onBoarding"){ OnBoarding(navController = navController) }
                }
            }
        }
    }
}