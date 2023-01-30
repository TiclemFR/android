package com.example.projetandroid.onBoarding

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetandroid.BonPlan.BonPlanDesc
import com.example.projetandroid.BonPlan.BonPlanImg
import com.example.projetandroid.BonPlan.page2
import com.example.projetandroid.models.Card
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.projetandroid.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import connectPreviewCard
import previewCard
import kotlin.math.ceil

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoarding(navController: NavController){
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    var auth: FirebaseAuth = Firebase.auth
    val db = Firebase.firestore
    var tabCard = remember{ mutableStateListOf<Card>() }
    db.collection("cards")
        .get()
        .addOnSuccessListener { result ->
            tabCard.clear()
            for (document in result) {
                var card: Card? = document.toObject()
                if (card != null) {
                    card.id = document.id
                    tabCard.add(card)
                    Log.i("CARD", "Adding card in tab.")
                    Log.i("CARD", "ID: " + card.id)
                }
            }
        }
        .addOnFailureListener { exception ->
            Log.w("CARD", "Error getting documents.", exception)
        }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .background(ButtonColor)) {

        Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)) {
            Text(text = "Pas de sous ?", style = Typography.h1, color = Color.White, textAlign = TextAlign.Center)
        }
        Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
        ){
            Text(text = "Y’A PADSOU.", style = Typography.h1, color = Color(0xFFfc77a6), textAlign = TextAlign.Center)
        }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 52.dp)
        ) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = Color.White,
                inactiveColor = Color(0xFF9fa4f2),
                indicatorHeight = 7.dp,
                indicatorWidth = 46.dp,
                spacing = 12.dp
            )
        }
        Row(modifier = Modifier.padding(top = 28.dp), horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier
                .width(245.dp)
                .height(250.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(BackgroundColor)

            ){
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 20.dp)
                ){
                    HorizontalPager(count = 1,//ceil(tabCard.slice(0..3).size/4.0).toInt(),
                        state = pagerState) { page ->

                        when (page) {
                            0 -> {
                                if(tabCard.size != 0) {
                                    Row() {
                                        Column(modifier = Modifier.padding(end = 3.dp)) {
                                            if(0 in 0..tabCard.lastIndex){
                                                Row(modifier = Modifier.padding(bottom = 3.dp)) {
                                                    connectPreviewCard(tabCard[0])
                                                }
                                            }
                                            if(1 in 0..tabCard.lastIndex){
                                                Row(modifier = Modifier.padding(top = 3.dp)) {
                                                    connectPreviewCard(tabCard[1])
                                                }
                                            }
                                        }
                                        Column(modifier = Modifier.padding(start = 3.dp)) {
                                            if(2 in 0..tabCard.lastIndex){
                                                Row(modifier = Modifier.padding(bottom = 3.dp)) {
                                                    connectPreviewCard(tabCard[2])
                                                }
                                            }
                                            if(3 in 0..tabCard.lastIndex){
                                                Row(modifier = Modifier.padding(top = 3.dp)) {
                                                    connectPreviewCard(tabCard[3])
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            1 -> {
                                Row() {
                                    Column(modifier = Modifier.padding(end = 3.dp)) {
                                        Row(modifier = Modifier.padding(bottom = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                        Row(modifier = Modifier.padding(top = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                    }
                                    Column(modifier = Modifier.padding(start = 3.dp)) {
                                        Row(modifier = Modifier.padding(bottom = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                        Row(modifier = Modifier.padding(top = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                    }
                                }
                            }
                            2 -> {
                                Row() {
                                    Column(modifier = Modifier.padding(end = 3.dp)) {
                                        Row(modifier = Modifier.padding(bottom = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                        Row(modifier = Modifier.padding(top = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                    }
                                    Column(modifier = Modifier.padding(start = 3.dp)) {
                                        Row(modifier = Modifier.padding(bottom = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                        Row(modifier = Modifier.padding(top = 3.dp)) {
                                            //connectPreviewCard()
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.Center) {
            Text(text = "Accède aux 500 bons plans\n qu’on te propose chaque mois",
                color = Color.White,
                style = Typography.h2,
                textAlign = TextAlign.Center)
        }
        //Button go
        Row(modifier = Modifier
            .fillMaxWidth().fillMaxHeight()
            .padding(bottom = 47.dp, start = 56.dp, end = 56.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom) {
            Button(onClick = {
                val currentUser = auth.currentUser
                if(currentUser != null){
                    navController.navigate("home")
                }
                else{
                    navController.navigate("login")
                }
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFfc77a6)),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .fillMaxWidth().height(56.dp),
            )

            {
                Text(text = "C EST PARTI ",color = Color.White, style = Typography.body2)
            }
        }
    }
}