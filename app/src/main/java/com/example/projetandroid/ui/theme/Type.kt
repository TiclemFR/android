package com.example.projetandroid.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projetandroid.R

// Set of Material typography styles to start with
val Inter = FontFamily(Font(R.font.inter_medium));
val InterCF = FontFamily(Font(R.font.fontspring_demo_integralcf_medium))
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Inter
    ),
    body2 = TextStyle(
        fontFamily = InterCF
    )
)