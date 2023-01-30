import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.inputmethodservice.Keyboard.Row
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.projetandroid.R
import com.example.projetandroid.login.Input
import com.example.projetandroid.ui.theme.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage


@Composable
fun profile(navController: NavController){
    val user = Firebase.auth.currentUser
    var pseudo by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val db = Firebase.firestore
    var picture by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        picture = uri
    }
    val context = LocalContext.current
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }
    androidx.compose.material.Surface(
        modifier = Modifier.fillMaxSize(),
        color = HomeBackgroundColor
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 58.dp)){
            Column(modifier = Modifier.width(244.dp)) {
                Row(
                    modifier = Modifier.padding(start = 33.dp),
                ) {
                    Text(text = "MON PROFIL", fontFamily = InterCF, fontSize = 26.sp, color = Color(0xFFFFFFFF))
                }
                Row(
                    modifier = Modifier.padding(top = 12.dp, start = 33.dp),
                ) {
                    Text(text = "Modifie tes infos affichees aux autres sur l'app", fontFamily = Inter, fontSize = 16.sp, color = Color(0xFFFFFFFF))
                }
            }
            Column(modifier = Modifier.width(44.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Color.White)
                        .clickable { launcher.launch("image/*") },
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
                ) {
                    if(picture == null && user?.photoUrl == null){
                        Text(text = "+", color = Color(0xFF5F67EA), fontSize = 20.sp)
                    }
                    else{
                        picture?.let {
                            if (Build.VERSION.SDK_INT < 28) {
                                bitmap.value = MediaStore.Images
                                    .Media.getBitmap(context.contentResolver, it)

                            } else {
                                val source = ImageDecoder
                                    .createSource(context.contentResolver, it)
                                bitmap.value = ImageDecoder.decodeBitmap(source)
                            }

                            bitmap.value?.let { btm ->
                                Image(
                                    bitmap = btm.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                        user?.photoUrl?.let {
                            AsyncImage(model = user?.photoUrl, contentDescription = null, modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 175.dp)
                .clip(shape = RoundedCornerShape(topEnd = 35.dp, topStart = 35.dp))
                .background(Color(0xFFF7F7F7))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 47.dp, start = 31.dp, end = 31.dp)
            ){
                Column() {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start), horizontalArrangement = Arrangement.Start){
                        Text(text = "MON PSEUDO", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 14.sp)
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Input(value = pseudo, placeholder = "mon pseudo", onValueChange = {newText -> pseudo = newText})
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 28.dp)
                        .align(Alignment.Start), horizontalArrangement = Arrangement.Start){
                        Text(text = "ADRESSE E-MAIL", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 14.sp)
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Input(value = email, placeholder = "adresse e-mail", onValueChange = {newText -> email = newText})
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 28.dp)
                        .align(Alignment.Start), horizontalArrangement = Arrangement.Start){
                        Text(text = "MOT DE PASSE", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 14.sp)
                    }
                    Row(modifier = Modifier.fillMaxWidth()){
                        Input(value = password, placeholder = "mot de passe", onValueChange = {newText -> password = newText}, password = true)
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(bottom = 110.dp, start = 31.dp, end = 31.dp),
                        verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(shape = RoundedCornerShape(15.dp))
                                .background(ButtonColor)
                                .clickable {
                                    val mImageRef = FirebaseStorage
                                        .getInstance()
                                        .getReference("users/" + user?.email + "/pp")
                                    mImageRef
                                        .putFile(picture!!)
                                        .addOnSuccessListener { task ->
                                            task.storage.downloadUrl.addOnSuccessListener { uri ->
                                                val profilUpdate = userProfileChangeRequest {
                                                    photoUri = uri
                                                    displayName = pseudo
                                                }
                                                user!!.updateProfile(profilUpdate)
                                            }
                                        }

                                },
                            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(text = "ENREGISTRER", fontFamily = InterCF, fontWeight = FontWeight(400), fontSize = 16.sp, color = Color(0xFFFFFFFF))
                        }
                    }
                }
            }
        }
    }
    navbar(navController = navController)
}