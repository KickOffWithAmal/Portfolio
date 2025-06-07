package com.kickoffwithamal.portfolio.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview


//@Composable
//fun InspireScreen() {
//    val quotes = listOf(
//        "Push yourself, because no one else is going to do it for you.",
//        "Great things never come from comfort zones.",
//        "Dream it. Wish it. Do it.",
//        "Success doesn’t just find you. You have to go out and get it."
//    )
//
//    var currentIndex by remember { mutableStateOf(0) }
//    val currentQuote = quotes[currentIndex]
//
//    // Background gradient animation
//    val infiniteTransition = rememberInfiniteTransition()
//    val color1 by infiniteTransition.animateColor(
//        initialValue = Color(0xFF8E2DE2),
//        targetValue = Color(0xFF4A00E0),
//        animationSpec = infiniteRepeatable(
//            animation = tween(3000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//    val color2 by infiniteTransition.animateColor(
//        initialValue = Color(0xFF4A00E0),
//        targetValue = Color(0xFF8E2DE2),
//        animationSpec = infiniteRepeatable(
//            animation = tween(3000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    // Quote auto-rotation
//    LaunchedEffect(Unit) {
//        while (true) {
//            delay(4000)
//            currentIndex = (currentIndex + 1) % quotes.size
//        }
//    }
//
//    // Fade animation
//    val alpha = remember { Animatable(0f) }
//    LaunchedEffect(currentQuote) {
//        alpha.snapTo(0f)
//        alpha.animateTo(1f, animationSpec = tween(1000))
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.linearGradient(
//                    colors = listOf(color1, color2),
//                    start = Offset.Zero,
//                    end = Offset.Infinite
//                )
//            ),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = currentQuote,
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Medium,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .padding(32.dp)
//                .alpha(alpha.value)
//        )
//    }
//}


import com.google.accompanist.pager.*
import com.kickoffwithamal.portfolio.ProfileImage
import com.kickoffwithamal.portfolio.utils.NotchedCard
import com.kickoffwithamal.portfolio.utils.StaggeredLazyList

@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun InspireScreen() {

    // Background animation (same as before)
    val infiniteTransition = rememberInfiniteTransition()
    val color1 by infiniteTransition.animateColor(
        initialValue = Color.Black, targetValue = Color.Yellow, animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing), repeatMode = RepeatMode.Reverse
        )
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = Color.Yellow, targetValue = Color.Black, animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing), repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(color1, color2),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
            .padding(top = 20.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                // Background gap behind the image (optional black or match screen color)
                Box(
                    modifier = Modifier
                        .padding(top = 115.dp) // 10dp below image
                        .size(width = 100.dp, height = 10.dp)
                        .background(Color.Black, shape = RoundedCornerShape(50)) // gap background
                )
                NotchedCard()
                // Profile Image on top
                ProfileImage()
            }

            Box(modifier = Modifier.padding(10.dp)
                .fillMaxSize()
            ) {
                StaggeredLazyList()
            }
        }
    }
}
