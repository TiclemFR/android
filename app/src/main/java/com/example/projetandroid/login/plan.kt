import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.projetandroid.R
import com.example.projetandroid.models.Card
import com.example.projetandroid.ui.theme.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


@Composable
fun plan(navController: NavController,id:String) {
    val db = Firebase.firestore
    val context = LocalContext.current
    var card:Card by remember { mutableStateOf(Card()) }
    db.collection("cards")
        .document(id)
        .get()
        .addOnSuccessListener { document ->
            card = document.toObject()!!
            card.id = document.id
        }
    if (card.id != "") {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(246.dp)
                .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        brush = Brush.horizontalGradient(
                            0.0f to Color(0xD4000000),
                            1.0f to Color(0x00000000),
                            startX = 0f,
                            endX = Float.POSITIVE_INFINITY
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    AsyncImage(model = card.image, contentDescription = null)
                }
            }
            Column(
                modifier = Modifier.padding(top = 98.dp),
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = card.title.toString(),
                        fontFamily = InterCF,
                        fontWeight = FontWeight(400),
                        fontSize = 22.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 54.dp)
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "2 mois offerts",
                        fontFamily = Inter,
                        fontWeight = FontWeight(700),
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 54.dp)
                    )
                }
            }

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .width(313.dp)
                    .padding(top = 277.dp)
                    .defaultMinSize(minHeight = 190.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 21.dp, start = 21.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .width(21.dp)
                            .height(21.dp)
                            .clip(shape = RoundedCornerShape(50.dp))
                            .background(Color.Black)
                    ) {

                    }
                    Column(
                        modifier = Modifier.padding(start = 11.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row() {
                            Text(
                                text = "Proposé par",
                                fontFamily = Inter,
                                fontWeight = FontWeight(500),
                                fontSize = 10.sp,
                                color = Color(0xFFA6A6A6)
                            )
                        }
                        Row() {
                            Text(
                                text = "Killian74",
                                fontFamily = Inter,
                                fontWeight = FontWeight(700),
                                fontSize = 10.sp,
                                color = Color(0xFF000000)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(start = 19.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        val nbYellowStar = card.star?.toInt()
                        for (i in 1..5) {
                            if (i <= nbYellowStar!!) {
                                Column(
                                    modifier = Modifier
                                        .width(17.dp)
                                        .height(17.dp)
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.ic_yellow_star),
                                        contentDescription = "yellow star",
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            } else {
                                Column(
                                    modifier = Modifier
                                        .width(17.dp)
                                        .height(17.dp)
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.ic_gray_star),
                                        contentDescription = "empty star",
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 73.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.width(273.dp)
                    ) {
                        Text(
                            text = card.resume.toString(),
                            fontFamily = Inter, fontWeight = FontWeight(500), fontSize = 14.sp
                        )
                    }
                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 484.dp), horizontalArrangement = Arrangement.Center
        ) {
            val nbGaleriens = card.galerien?.toInt();
            Text(
                text = "TESTEE PAR " + nbGaleriens + " GALERIENS",
                fontFamily = InterCF,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                color = Color(0xFF1B191A),
                modifier = Modifier.width(212.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .fillMaxSize()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Row(
                modifier = Modifier
                    .width(313.dp)
                    .height(56.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color(0xFF5F67EA))
                    .clickable {
                        if (!card.link?.startsWith("http://")!! && !card.link?.startsWith("https://")!!)
                            card.link = "http://" + card.link;
                        val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(card.link))
                        db.collection("cards").document(card.id.toString())
                            .update("galerien", (card.galerien?.toInt()?.plus(1)).toString())
                        context.startActivity(myIntent)
                    },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "PROFITER DE L OFFRE",
                    fontFamily = InterCF,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}