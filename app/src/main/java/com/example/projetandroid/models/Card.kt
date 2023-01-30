package com.example.projetandroid.models

import com.google.firebase.auth.FirebaseUser

data class Card(
    var id:String? = "",
    var title:String? = "",
    var resume:String? = "",
    var link:String? = "",
    var image:String? = "",
    var star:String? = "0",
    var galerien:String? = "0",
    var user:String? = ""
)