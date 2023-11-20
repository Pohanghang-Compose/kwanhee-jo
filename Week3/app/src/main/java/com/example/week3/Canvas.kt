package com.example.week3

import android.graphics.Paint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun RainbowCanvas(starNumber: MutableState<Int>) {
    val starMax = 25f
    var percent = starNumber.value.toFloat()
    val percentAnimated by animateFloatAsState(
        targetValue = percent,
        label = "star count animation"
    )

    Canvas(
        modifier = Modifier
            .size(320.dp)
            .padding(16.dp)
    ) {
        drawArc(
            color = Color.LightGray,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            size = Size(800.dp.value, 800.dp.value),
            style = Stroke(width = 20f, cap = StrokeCap.Round)
        )

        drawArc(
            color = Color.Red,
            startAngle = 180f,
//            sweepAngle = (180f * starNumber.value) / starMax, // 180 : n = 전체 별점 : 내 별점 (n = 그림에서 나타나는 퍼센트)
            sweepAngle = (180f * percentAnimated) / starMax,
            useCenter = false,
            size = Size(800.dp.value, 800.dp.value),
            style = Stroke(width = 20f, cap = StrokeCap.Round)
        )

        drawContext.canvas.nativeCanvas.drawText(
            "지금 내 점수는",
            225f,
            200f,
            Paint().apply {
                textSize = 64f
                color = 0xff625b71.toInt()
            }
        )
        drawContext.canvas.nativeCanvas.drawText(
            "${((starNumber.value / starMax) * 100).toInt()}",  // (180 : n = 전체 별점 : 내 별점) * 100, 백분율 때문에 100 곱하기
            365f,
            350f,
            Paint().apply {
                textSize = 100f
                color = 0xffff0000.toInt()
            }
        )

    }
}