package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat

@Composable
fun CongratsBouttonEtLogo(activity: Activity) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.fest2_icon),
            contentDescription = "félicitations"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.reussi),
            fontSize = 16.sp,
            lineHeight = 8.sp,
            color = colorResource(R.color.purple_200)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            val navigate = Intent(activity, EvenementTest::class.java)
            ContextCompat.startActivity(activity,navigate, Bundle.EMPTY)
        }) {
            Text(stringResource(R.string.congrats))
        }
    }
}

//@Preview
//@Composable
//fun CongratsApp() {
//    CongratsBouttonEtLogo(modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize(Alignment.Center)
//    )
//}
