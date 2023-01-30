package com.example.projetandroid.BonPlan

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projetandroid.models.Card
import com.example.projetandroid.ui.theme.ButtonColor
import com.example.projetandroid.ui.theme.Typography
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun BonPlanImg(navController: NavController, card:Card){
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

    Column() {
        //Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 34.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Photo du bon plan", style = Typography.h1, textAlign = TextAlign.Center)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            if(picture == null){
                Button(
                    onClick = {
                        launcher.launch("image/*")
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor),
                    shape = RoundedCornerShape(20),
                    modifier = Modifier
                        .width(174.dp)
                        .height(160.dp)
                )

                {
                    Text(text = "+", color = Color.White, fontSize = 40.sp)
                }
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
                            modifier = Modifier.size(260.dp)
                        )
                    }
                }
            }
        }
        //Button add
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 0.dp, start = 31.dp, bottom = 110.dp, end = 31.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(onClick = {
                db.collection("cards").add(card).addOnSuccessListener {
                    navController.navigate("home")
                }
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .width(327.dp)
                    .height(56.dp)
            )

            {
                Text(text = "Ajouter ce bon plan",color = Color.White, style = Typography.body2)
            }
        }
    }
}