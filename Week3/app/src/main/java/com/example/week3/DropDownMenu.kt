package com.example.week3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week3.ui.theme.Yellow

@Composable
fun StarDropDownMenu(
    text: String,
    onResult: (Int) -> Unit
) {
    val isDropDownMenuExpanded = remember { mutableStateOf(false) }
    var item = remember { mutableStateOf(0) }

    Row {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(vertical = 8.dp)
                .clickable {
                    isDropDownMenuExpanded.value = true
                },
            fontSize = 16.sp,
            lineHeight = 17.sp,
        )
        DropdownMenu(
            modifier = Modifier
                .width(50.dp)
                .wrapContentSize(),
            offset = DpOffset(250.dp, 0.dp),
            expanded = isDropDownMenuExpanded.value,
            onDismissRequest = {
                isDropDownMenuExpanded.value = false
                onResult(0)
            }
        ) {
            DropdownMenuItem(
                text = { Text(text = "1") },
                onClick = {
                    onResult(1)
                    item.value = 1
                    isDropDownMenuExpanded.value = false
                }
            )
            DropdownMenuItem(
                text = { Text(text = "2") },
                onClick = {
                    onResult(2)
                    item.value = 2
                    isDropDownMenuExpanded.value = false
                }
            )
            DropdownMenuItem(
                text = { Text(text = "3") },
                onClick = {
                    onResult(3)
                    item.value = 3
                    isDropDownMenuExpanded.value = false
                }
            )
            DropdownMenuItem(
                text = { Text(text = "4") },
                onClick = {
                    onResult(4)
                    item.value = 4
                    isDropDownMenuExpanded.value = false
                }
            )
            DropdownMenuItem(
                text = { Text(text = "5") },
                onClick = {
                    onResult(5)
                    item.value = 5
                    isDropDownMenuExpanded.value = false
                }
            )
        }
    }

    StarRating(item.value)
}

@Composable
fun StarRating(count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until count) {
            Icon(imageVector = Icons.Filled.Star, contentDescription = "star", tint = Yellow)
        }
    }
}