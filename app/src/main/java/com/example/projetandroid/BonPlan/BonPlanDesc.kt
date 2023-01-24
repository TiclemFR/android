package com.example.projetandroid.BonPlan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetandroid.login.Input
import com.example.projetandroid.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BonPlanDesc(pagerState: PagerState, coroutineScope: CoroutineScope){
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var link by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxHeight().verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
        //Title
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 34.dp, start = 31.dp)) {
            Text(text = "Titre", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 14.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp), horizontalArrangement = Arrangement.Center) {
            Input(value = title, placeholder = "Abonnement 1 an Basic-Fit",
                onValueChange = {newText -> title = newText})
        }
        //Desc
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp, start = 31.dp)) {
            Text(text = "Description", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 14.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.dp), horizontalArrangement = Arrangement.Center) {
            TextField(value = description,
                modifier = Modifier.width(327.dp).height(90.dp),
                onValueChange = { description = it },
                placeholder = { Text(text = "Ne soit pas trop bavard, on s’en fou, va à l’essentiel")},
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = BackgroundColorInput,
                    placeholderColor = PlaceHolderColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
            )
        }
        //Lien
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp, start = 31.dp)) {
            Text(text = "Lien", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 14.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp), horizontalArrangement = Arrangement.Center) {
            Input(value = link, placeholder = "www.lienverstonbonplan.com",
                onValueChange = {newText -> link = newText})
        }
        //Button next
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 34.dp), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                page2(pagerState, coroutineScope)
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .width(327.dp)
                    .height(56.dp)
            )

            {
                Text(text = "SUIVANT",color = Color.White, style = Typography.body2)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
fun page2(pagerState: PagerState, coroutineScope:CoroutineScope){
    coroutineScope.launch {
        pagerState.animateScrollToPage(1)
    }
}