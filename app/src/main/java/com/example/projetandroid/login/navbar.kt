import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.projetandroid.R

@Composable
fun navbar(navController: NavController){
    Row(
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.Bottom
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(78.dp)
                .clip(shape = RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                .background(Color(0xFFFFFFFF)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
        ){
            Row(
                modifier = Modifier
                    .width(175.dp)
                    .height(78.dp)
                    .background(Color.Transparent),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                    modifier = Modifier
                        .width(49.dp)
                        .height(49.dp)
                        .clickable { navController.navigate("home") }
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(Color(0xFFF2F2F2)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (navController.currentDestination?.route.toString() == "home"){
                        Image(painterResource(id = R.drawable.ic_current_home), contentDescription = "home icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(20.dp)
                            .height(21.dp))
                    }else{
                        Image(painterResource(id = R.drawable.ic_home), contentDescription = "home icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(20.dp)
                            .height(21.dp))
                    }
                }
                Row(
                    modifier = Modifier
                        .width(49.dp)
                        .height(49.dp)
                        .clickable { navController.navigate("add") }
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(Color(0xFFF2F2F2)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if(navController.currentDestination?.route.toString() == "add"){
                        Image(painterResource(id = R.drawable.ic_current_add), contentDescription = "add icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(25.dp)
                            .height(25.dp))
                    }else{
                        Image(painterResource(id = R.drawable.ic_add), contentDescription = "add icon", modifier = Modifier
                            .background(Color.Transparent)
                            .width(25.dp)
                            .height(25.dp))
                    }
                }
                Row(
                    modifier = Modifier
                        .width(49.dp)
                        .height(49.dp)
                        .clickable { }
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(Color(0xFFF2F2F2)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painterResource(id = R.drawable.ic_profile), contentDescription = "profile icon", modifier = Modifier
                        .background(Color.Transparent)
                        .width(25.dp)
                        .height(25.dp))
                }
            }
        }
    }
}
