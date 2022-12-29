package com.example.businesscard

import android.media.tv.TvContract
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Call(
        fullName = stringResource(id = R.string.fullName),
        title = stringResource(id = R.string.title),
        call = stringResource(id = R.string.call),
        job = stringResource(id = R.string.job),
        email = stringResource(id = R.string.email),
        imagePainter = painterResource(id = R.drawable.android_logo),
        icon1Painter = painterResource(id = R.drawable.baseline_phone_black_24dp),
        icon2Painter = painterResource(id = R.drawable.baseline_share_black_24dp),
        icon3Painter = painterResource(id = R.drawable.baseline_email_black_24dp)

    )
}

@Composable
fun Call(
    fullName : String,
    title : String,
    call: String,
    job : String,
    email : String,
    imagePainter: Painter,
    icon1Painter : Painter,
    icon2Painter : Painter,
    icon3Painter : Painter,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 250.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
            )
            Column() {
                Text(
                    text = fullName,
                    fontSize = 36.sp,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
                Text(
                    text = title,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

    }
    Column(modifier = modifier
//        .fillMaxSize()
        .fillMaxWidth()
        .padding(top = 500.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier
            .padding(end = 100.dp)) { //top = 10.dp, bottom = 10.dp, end = 50.dp
            Image(
                painter = icon1Painter,
                contentDescription = null,

                modifier = Modifier
                    .size(20.dp)
//                    .padding(10.dp)
            )
            Text(
                text = call,
                modifier = Modifier
                .wrapContentWidth(Alignment.Start)
            )
            
        }
        Row(modifier = Modifier
            .padding(end = 100.dp)) {
            Image(
                painter = icon2Painter,
                contentDescription = null,

                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = job,
                modifier = Modifier
                .wrapContentWidth(Alignment.Start)

            )
        }
        Row(modifier = Modifier
            .padding(end = 100.dp)) {
            Image(
                painter = icon3Painter,
                contentDescription = null,

                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = email,
                modifier = Modifier
                .wrapContentWidth(Alignment.Start)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardApp()
}