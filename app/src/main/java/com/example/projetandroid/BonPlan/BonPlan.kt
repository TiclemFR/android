package com.example.projetandroid.BonPlan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.projetandroid.ui.theme.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BonPlan(navController: NavController){
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .background(ButtonColor)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 33.dp)) {
            Text(text = "Ajouter", style = Typography.h1, color = Color.White)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 13.dp, start = 33.dp)) {
            Text(
                text = "Un bon plan pour en faire\n profiter les autres",
                style = Typography.h2,
                color = Color.White
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 40.dp)
                .clip(shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                .background(BackgroundColor)
        ) {
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(top = 27.dp)
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = ButtonColor,
                    inactiveColor = Color(0xffbabfcd),
                    indicatorHeight = 7.dp,
                    indicatorWidth = 46.dp,
                    spacing = 12.dp
                )
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()) {
                HorizontalPager(count = 2,
                    state = pagerState,
                userScrollEnabled = false) {page ->

                    when(page){
                        0 -> BonPlanDesc(pagerState, coroutineScope)
                        1 -> BonPlanImg(navController)
                    }

                }
            }

        }

    }
}