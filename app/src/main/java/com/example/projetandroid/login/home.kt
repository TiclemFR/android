import android.graphics.BitmapFactory
import android.inputmethodservice.Keyboard.Row
import android.util.Log
import android.widget.ImageView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.projetandroid.R
import com.example.projetandroid.models.Card
import com.example.projetandroid.ui.theme.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.net.URL


@Composable
fun home(navController: NavController){
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
    androidx.compose.material.Surface(
        modifier = Modifier.fillMaxSize(),
        color = HomeBackgroundColor
    ){
            Row(
                modifier = Modifier.padding(top = 58.dp, start = 33.dp),
            ) {
                Text(text = "Coucou toi,", fontFamily = InterCF, fontSize = 26.sp, color = Color(0xFFFFFFFF))
            }
            Row(
                modifier = Modifier.padding(top = 97.dp, start = 33.dp),
            ) {
                Text(text = "T'es en manque de thunes ?", fontFamily = Inter, fontSize = 16.sp, color = Color(0xFFFFFFFF))
            }

        Row(
            modifier = Modifier.padding(top = 164.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            var value by remember { mutableStateOf(TextFieldValue("")) }
            TextField(value = value, onValueChange = { newValue -> value = newValue }, placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(id = R.drawable.ic_search), contentDescription = "search icon", modifier = Modifier
                    .background(Color.Transparent)
                    .width(18.dp)
                    .height(18.dp))
                Text(text = "     Cherche un bon plan", color = Color(0xFFD2CECE))
            }}, shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = InputBG,
                    placeholderColor = Color(0xFFA6A6A6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent))
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 254.dp)
                .clip(shape = RoundedCornerShape(topEnd = 35.dp, topStart = 35.dp))
                .background(Color(0xFFF7F7F7))
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    modifier = Modifier
                        .width(294.dp)
                        .height(57.dp), horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Column(
                        modifier = Modifier
                            .height(57.dp)
                            .width(57.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(Color(0xFF605DF5))
                            .clickable { },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(id = R.drawable.ic_shop), contentDescription = "shop icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(16.dp)
                            .height(20.dp))
                    }
                    Column(
                        modifier = Modifier
                            .height(57.dp)
                            .width(57.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(Color(0xFFF4696A))
                            .clickable { },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(id = R.drawable.ic_sport), contentDescription = "sport icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(18.dp)
                            .height(21.dp))
                    }
                    Column(
                        modifier = Modifier
                            .height(57.dp)
                            .width(57.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(Color(0xFF579BFE))
                            .clickable { },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(id = R.drawable.ic_train), contentDescription = "train icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(23.dp)
                            .height(19.dp))
                    }
                    Column(
                        modifier = Modifier
                            .height(57.dp)
                            .width(57.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(Color(0xFF7C8CF9))
                            .clickable { },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(id = R.drawable.ic_party), contentDescription = "party icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(20.dp)
                            .height(20.dp))
                    }
                }
                Row(
                    modifier = Modifier
                        .width(294.dp)
                        .padding(top = 10.dp)
                        .height(16.dp), horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        modifier = Modifier.width(57.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "COURSES", fontFamily = InterCF, fontSize = 10.sp, color = Color(0xFF605DF5))
                    }
                    Column(
                        modifier = Modifier.width(57.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "SPORT", fontFamily = InterCF, fontSize = 10.sp, color = Color(0xFFF4696A))
                    }
                    Column(
                        modifier = Modifier.width(57.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "TRAINS", fontFamily = InterCF, fontSize = 10.sp, color = Color(0xFF579BFE))
                    }
                    Column(
                        modifier = Modifier.width(57.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "SOIREES", fontFamily = InterCF, fontSize = 10.sp, color = Color(0xFF7C8CF9))
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 39.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        modifier = Modifier.padding(start = 26.dp),
                        horizontalAlignment = Alignment.Start
                    ){
                        Text(text = "LES PLANS DU MOMENT", fontFamily = InterCF, fontSize = 14.sp, color = Color(0xFF1B191A))
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 22.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.End
                    ){
                        Text(text = "Voir tout", fontFamily = InterCF, fontSize = 14.sp, color = Color(0xFFFC6B68))
                    }
                }
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(bottom = 80.dp)
                ){
                    if(tabCard.size != 0){
                        for(i in 0..tabCard.lastIndex step 2){
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp), horizontalArrangement = Arrangement.Center){
                                Column(
                                    modifier = Modifier.padding(end = 4.dp),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    previewCard(tabCard[i], navController)
                                }
                                if(i+1 in 0..tabCard.lastIndex){
                                    Column(
                                        modifier = Modifier.padding(start = 4.dp),
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        previewCard(tabCard[i+1], navController)
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    navbar(navController = navController)
}

@Composable
fun previewCard(card:Card, navController: NavController){
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .width(159.dp)
            .height(162.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color(0xFFFFFFFF))
            .padding(top = 6.dp)
            .clickable { navController.navigate("plan/" + card.id) },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .width(144.dp)
                    .height(90.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = Color(0xFF555555))
            ){
                AsyncImage(
                    model = card.image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .width(33.dp)
                    .height(33.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .border(3.dp, color = Color(0xFFFFFFFF), shape = RoundedCornerShape(50.dp)))
            {
                var pp by remember { mutableStateOf("") }
                val mImageRef = FirebaseStorage.getInstance().getReference()
                mImageRef.child("users/"+card.user+"/pp").downloadUrl.addOnSuccessListener {uri ->
                    pp = uri.toString()
                }
                AsyncImage(
                    model = pp,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 113.dp, start = 14.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text(text = card.title.toString(), fontFamily = Inter, fontWeight = FontWeight(700), fontSize = 12.sp)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 129.dp, start = 14.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "2 mois offerts", fontFamily = Inter, fontWeight = FontWeight(500), fontSize = 10.sp)
        }
    }
}

@Composable
fun connectPreviewCard(card: Card){
    Box(
        modifier = Modifier
            .width(105.dp)
            .height(105.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color(0xFFFFFFFF))
            .padding(top = 3.dp)
            .clickable { },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .width(94.dp)
                    .height(58.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = Color(0xFF555555))
            ){
                AsyncImage(model = card.image, contentDescription = null, modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 47.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .width(23.dp)
                    .height(23.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .border(2.dp, color = Color(0xFFFFFFFF), shape = RoundedCornerShape(50.dp)))
            {
                var pp by remember { mutableStateOf("") }
                val mImageRef = FirebaseStorage.getInstance().getReference()
                mImageRef.child("users/"+card.user+"/pp").downloadUrl.addOnSuccessListener {uri ->
                    pp = uri.toString()
                }
                AsyncImage(
                    model = pp,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 77.dp, start = 9.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "Abonnement 1 an", fontFamily = Inter, fontWeight = FontWeight(700), fontSize = 9.sp)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 88.dp, start = 9.dp),
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "2 mois offerts", fontFamily = Inter, fontWeight = FontWeight(500), fontSize = 7.sp)
        }
    }
}