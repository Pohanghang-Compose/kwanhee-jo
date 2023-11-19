package com.example.week3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun StarDialog(
    openDialog: MutableState<Boolean>,
    onResult: (Int) -> Unit
) {
    var starNumberResult = 0;

    Dialog(onDismissRequest = {
        openDialog.value = !openDialog.value
        onResult(starNumberResult)
    }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
//                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White
        ) {
            DialogContent(openDialog) {
                starNumberResult += it
                onResult(starNumberResult)
            }
        }
    }
}

@Composable
fun DialogContent(
    openDialog: MutableState<Boolean>,
    onResult: (Int) -> Unit
) {
    var startNumberResult = 0
    Column {
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )

        StarDropDownMenu("Compose 스터디 만족도") { startNumberResult += it }
        StarDropDownMenu("Compose 스터디 난이도") { startNumberResult += it }
        StarDropDownMenu("오늘 점심 메뉴 만족도") { startNumberResult += it }
        StarDropDownMenu("오늘 저녁 메뉴 만족도") { startNumberResult += it }
        StarDropDownMenu("SOPT 만족도") { startNumberResult += it }

        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = {
                openDialog.value = false
                onResult(startNumberResult)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "확인", fontSize = 16.sp)
        }
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        )
    }
}