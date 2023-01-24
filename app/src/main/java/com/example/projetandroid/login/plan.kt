import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetandroid.ui.theme.Inter
import com.example.projetandroid.ui.theme.InterCF
import android.inputmethodservice.Keyboard.Row
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.projetandroid.R
import com.example.projetandroid.ui.theme.*

@Composable
fun plan(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(246.dp)
            .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp))
    ){
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
        ){
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ){

            }
        }
        Column(
            modifier = Modifier.padding(top = 98.dp),
        ){
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ABONNEMENT 1 AN",
                    fontFamily = InterCF,
                    fontWeight = FontWeight(400),
                    fontSize = 22.sp,
                    color = Color.White,
                modifier = Modifier.padding(start = 54.dp))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "2 mois offerts",
                    fontFamily = Inter,
                    fontWeight = FontWeight(700),
                    fontSize = 12.sp,
                    color = Color.White,
                modifier = Modifier.padding(start = 54.dp))
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
                        Text(text = "Proposé par", fontFamily = Inter, fontWeight = FontWeight(500), fontSize = 10.sp, color = Color(0xFFA6A6A6))
                    }
                    Row() {
                        Text(text = "Killian74", fontFamily = Inter, fontWeight = FontWeight(700), fontSize = 10.sp, color = Color(0xFF000000))
                    }
                }
                Row(
                    modifier = Modifier.padding(start = 19.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val nbYellowStar = 4
                    for (i in 1..5){
                        if (i <= nbYellowStar){
                            Column(
                                modifier = Modifier
                                    .width(17.dp)
                                    .height(17.dp)
                            ) {
                                Image(painterResource(id = R.drawable.ic_yellow_star), contentDescription = "yellow star", modifier = Modifier.fillMaxWidth())
                            }
                        }else{
                            Column(
                                modifier = Modifier
                                    .width(17.dp)
                                    .height(17.dp)
                            ) {
                                Image(painterResource(id = R.drawable.ic_gray_star), contentDescription = "empty star", modifier = Modifier.fillMaxWidth())
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
            ){
                Row(
                    modifier = Modifier.width(273.dp)
                ) {
                    Text(
                        text = "Chaque année, O'Tacos veut vous mettre bien. On sait bien que t'es étudiant et que c'est la galère, alors on a prévue des giga MAXI TACOS à des giga BAS PRIX. Ca se passe maintenant !",
                        fontFamily = Inter, fontWeight = FontWeight(500), fontSize = 14.sp)
                }
            }

        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 484.dp), horizontalArrangement = Arrangement.Center
    ){
        val nbGaleriens = 32;
        Text(text = "TESTEE PAR "+nbGaleriens+" GALERIENS",
            fontFamily = InterCF,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            color = Color(0xFF1B191A),
            modifier = Modifier.width(212.dp))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize().padding(bottom = 30.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ){
        Row(
            modifier = Modifier
                .width(313.dp)
                .height(56.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Color(0xFF5F67EA)).clickable {  },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "PROFITER DE L OFFRE",
                fontFamily = InterCF,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}