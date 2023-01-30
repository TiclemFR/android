package com.example.projetandroid.models

import com.google.firebase.auth.FirebaseUser

data class Card(
    var title:String? = "",
    var resume:String? = "",
    var link:String? = "",
    var image:String? = "",
    var star:Number? = 0,
    var user:FirebaseUser? = null
)