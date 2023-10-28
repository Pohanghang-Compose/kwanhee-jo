package com.example.week1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week1.ui.theme.LightGrey
import com.example.week1.ui.theme.Week1Theme
import com.example.week1.ui.theme.Yellow
import com.example.week1.ui.theme.YellowGrey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week1Theme {
                profileCard(
                    Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun profileCard(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small, // surface에서 가장자리를 둥글게 하는 방법 (surface는 border가 없기때문에)
        modifier = modifier,
        color = LightGrey
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "IDENTIFICATION CARD",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Yellow)
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Image(
                painter = painterResource(id = R.drawable.pikachu),
                contentDescription = "android circle",
                modifier = Modifier
                    .size(260.dp)

            )

            Spacer(modifier = Modifier.size(40.dp))

            Text(
                text = "Pikachu",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = "{ 피카츄 입니다만... }",
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.size(40.dp))

            textRowLine(firstWord = "분류", secondWord = "전기쥐 포켓몬")
            textRowLine(firstWord = "신장/체중/포획률", secondWord = "0.4m/6.0kg/190")
            textRowLine(firstWord = "기술", secondWord = "1000만 볼트")

            Spacer(modifier = Modifier.size(60.dp))


            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Yellow)
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pikachu_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                )

                Spacer(modifier = Modifier.size(10.dp))

                Text(
                    text = "UNIVERSAL POCKETMON BALL",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(3f)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun textRowLine(firstWord: String, secondWord: String) {
    Row(
        modifier = Modifier.padding(start = 30.dp, end = 30.dp)
    ) {
        Text(
            text = firstWord,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = secondWord,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.weight(2f)
        )
    }
    Divider(
        color = YellowGrey,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(2.dp)
    )
    Spacer(modifier = Modifier.size(1.dp))
}