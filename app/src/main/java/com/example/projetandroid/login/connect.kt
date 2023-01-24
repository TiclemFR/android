import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projetandroid.*
import com.example.projetandroid.ui.theme.*

@Composable
fun connectPage(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = GrayBG
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
            ,
            horizontalArrangement = Arrangement.Center
        ) {
            Title()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 119.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            subTitle()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 221.dp)
                .width(327.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            emailField()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 294.dp)
                .width(327.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            passwordField()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 367.dp)
                .width(327.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            confirmPasswordField()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 486.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            mention()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 531.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            connect(navController)
        }
        Row(
            modifier = Modifier
                .padding(bottom = 37.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            textButton(navController)
        }
    }
}

@Composable
fun Title() {
    Text("Bienvenue 😎", fontSize = 26.sp, fontFamily = InterCF);
}

@Composable
fun subTitle(){
    Text("Inscris-toi pour avoir les \nmeilleurs plans étudiants !", fontSize = 18.sp, fontFamily = Inter)
}

@Composable
fun emailField(){
    var value by remember { mutableStateOf(TextFieldValue("")) }
    TextField(value = value, onValueChange = { newValue -> value = newValue }, placeholder = { Text(text = "Ton adresse e-mail") }, shape = RoundedCornerShape(15.dp), colors = TextFieldDefaults.textFieldColors(backgroundColor = InputBG, placeholderColor = Color(0xFFA6A6A6), focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent, disabledIndicatorColor = Color.Transparent))
}

@Composable
fun passwordField(){
    var value by remember { mutableStateOf(TextFieldValue("")) }
    TextField(value = value, onValueChange = { newValue -> value = newValue }, placeholder = { Text(text = "Ton mot de passe") }, shape = RoundedCornerShape(15.dp), colors = TextFieldDefaults.textFieldColors(backgroundColor = InputBG, placeholderColor = Color(0xFFA6A6A6), focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent, disabledIndicatorColor = Color.Transparent), visualTransformation = PasswordVisualTransformation())
}

@Composable
fun confirmPasswordField(){
    var value by remember { mutableStateOf(TextFieldValue("")) }
    TextField(value = value, onValueChange = { newValue -> value = newValue }, placeholder = { Text(text = "Confirme ton mot de passe") }, shape = RoundedCornerShape(15.dp), colors = TextFieldDefaults.textFieldColors(backgroundColor = InputBG, placeholderColor = Color(0xFFA6A6A6), focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent, disabledIndicatorColor = Color.Transparent), visualTransformation = PasswordVisualTransformation())
}

@Composable
fun mention(){
    Text(text = "En t'inscrivant, tu acceptes les Conditions générales \nd'utilisation de Padsou", color = Color(0xFF747685), fontSize = 12.sp, fontFamily = Inter)
}

@Composable
fun connect(navController: NavController){
    Button(onClick = { navController.navigate("home") },
        Modifier
            .height(56.dp)
            .width(327.dp), colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBG), shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = "SE CONNECTER", color = Color(0xFFFFFFFF), fontSize = 16.sp, fontFamily = InterCF)
    }
}

@Composable
fun textButton(navController: NavController){
    Row(modifier = Modifier.clickable { navController.navigate("login") }){
        Text("Déjà un compte ? ", color = Color(0xFF747685), fontSize = 12.sp, fontFamily = Inter)
        Text("Connecte-toi !", color = Color(0xFF5F67EA), fontSize = 12.sp, fontFamily = Inter)
    }
}