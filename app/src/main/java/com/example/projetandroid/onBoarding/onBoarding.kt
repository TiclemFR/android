package com.example.projetandroid.onBoarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.projetandroid.ui.theme.*
import previewCard

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoarding(navController: NavController){
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
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
        Row(horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .padding(top = 28.dp, start = 30.dp, end = 30.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(BackgroundColor)

            ){
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 20.dp)
                ){
                    HorizontalPager(count = 3,
                        state = pagerState) { page ->

                        when (page) {
                            0 -> {
                                Row() {
                                    Column() {
                                        Row {
                                            previewCard()
                                        }
                                        Row {
                                            previewCard()
                                        }
                                    }
                                    Column() {
                                        Row {
                                            previewCard()
                                        }
                                        Row {
                                            previewCard()
                                        }
                                    }
                                }
                            }
                            1 -> {
                                Row() {
                                    Column() {
                                        Row {
                                            previewCard()
                                        }
                                        Row {
                                            previewCard()
                                        }
                                    }
                                    Column() {
                                        Row {
                                            previewCard()
                                        }
                                        Row {
                                            previewCard()
                                        }
                                    }
                                }
                            }
                            2 -> {
                                Row() {
                                    Column() {
                                        Row {
                                            previewCard()
                                        }
                                        Row {
                                            previewCard()
                                        }
                                    }
                                    Column() {
                                        Row {
                                            previewCard()
                                        }
                                        Row {
                                            previewCard()
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
            .fillMaxWidth()
            .padding(top = 34.dp), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                navController.navigate("login")
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFfc77a6)),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .width(327.dp)
                    .height(56.dp),
            )

            {
                Text(text = "C EST PARTI ",color = Color.White, style = Typography.body2)
            }
        }
    }
}