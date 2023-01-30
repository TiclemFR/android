package com.example.projetandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetandroid.BonPlan.BonPlan
import com.example.projetandroid.login.loginPage
import com.example.projetandroid.models.Card
import com.example.projetandroid.onBoarding.OnBoarding
import com.example.projetandroid.ui.theme.*
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import connectPage
import home
import navbar
import plan
import previewCard
import profile

class MainActivity : ComponentActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        val db = Firebase.firestore
        setContent {
            ProjetAndroidTheme {
                navController = rememberNavController()
                NavHost(navController = navController as NavHostController,
                    startDestination = "onBoarding"){
                    composable("register"){connectPage(navController)}
                    composable("login"){loginPage(navController)}
                    composable("add"){ BonPlan(navController = navController)}
                    composable("onBoarding"){ OnBoarding(navController = navController) }
                    composable("home"){ home(navController = navController) }
                    composable("profil"){ profile(navController = navController) }
                }
            }
        }
    }
}