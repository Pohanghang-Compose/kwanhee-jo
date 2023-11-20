package com.example.week3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week3.ui.theme.Week3Theme
import com.example.week3.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week3Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ParkDongMin()
                }
            }
        }
    }
}

@Composable
fun ParkDongMin() {
    var starNumber = remember { mutableStateOf(0) }
    val surveyTextList =
        listOf("Compose 스터디 만족도", "Compose 스터디 난이도", "오늘 점심 메뉴 만족도", "오늘 저녁 메뉴 만족도", "SOPT 만족도")
    val starNumberList = MutableList(surveyTextList.size) { i -> 0 }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(10.dp))

        RainbowCanvas(starNumber)

        repeat(surveyTextList.size) {
            surveyContent(surveyText = surveyTextList[it]) { count ->
                starNumberList[it] = count
                starNumber.value = starNumberList.sum()
            }
        }
    }
}

@Composable
fun surveyContent(surveyText: String, onResult: (Int) -> Unit) {
    var onClickDropdown by remember { mutableStateOf(false) }
    var starCount by remember { mutableStateOf(0) }
    val starAnimated by animateIntAsState(targetValue = starCount)

    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = surveyText,
                fontSize = 24.sp
            )
            Icon(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        onClickDropdown = !onClickDropdown
                    },
                imageVector = if (onClickDropdown) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                contentDescription = "dropdown",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        expandedDropDown(isDropDownMenuExpanded = onClickDropdown) { onDismiss, count ->
            onClickDropdown = onDismiss
            starCount = count
            onResult(count)
        }

        Row {
            repeat(starAnimated) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star",
                    tint = Yellow
                )
            }
        }
    }
}

@Composable
fun expandedDropDown(isDropDownMenuExpanded: Boolean, onDismiss: (Boolean, Int) -> Unit) {
    DropdownMenu(
        modifier = Modifier
            .width(50.dp)
            .wrapContentSize(),
        offset = DpOffset(250.dp, 0.dp),
        expanded = isDropDownMenuExpanded,
        onDismissRequest = {
            onDismiss(false, 0)
        }
    ) {
        repeat(5) {
            DropdownMenuItem(
                text = { Text(text = (it + 1).toString()) },
                onClick = { onDismiss(false, (it + 1)) })
        }
    }
}