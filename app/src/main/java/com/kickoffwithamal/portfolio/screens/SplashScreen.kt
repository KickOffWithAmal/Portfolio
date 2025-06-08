package com.kickoffwithamal.portfolio.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationState
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.kickoffwithamal.portfolio.R
import kotlinx.coroutines.delay
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

@Composable
fun SplashScreen(
    composition: LottieComposition?,
    progress: Float
) {
    // Background animation (same as before)
    val infiniteTransition = rememberInfiniteTransition()
    val color1 by infiniteTransition.animateColor(
        initialValue = Color(0xFF000000), targetValue = Color(0xFF222222), animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing), repeatMode = RepeatMode.Reverse
        )
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = Color(0xFF222222), targetValue = Color(0xFF000000), animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing), repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                Brush.linearGradient(
                colors = listOf(color1, color2),
                start = Offset.Zero,
                end = Offset.Infinite
            )),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (composition != null) {
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.size(300.dp)  // Add size or it might be zero size
            )
        }
    }
}

@Preview
@Composable
fun AppEntry() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coder_splash))
    val animationState = animateLottieCompositionAsState(
        composition = composition,
        iterations = 1,
        isPlaying = composition != null
    )

    var showSplash by remember { mutableStateOf(true) }

    LaunchedEffect(composition, animationState.isAtEnd, animationState.isPlaying) {
        if (composition != null && animationState.isAtEnd && !animationState.isPlaying) {
            showSplash = false
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = showSplash,
            exit = fadeOut(animationSpec = tween(500)) + slideOutVertically(),
            enter = fadeIn(animationSpec = tween(500)) + slideInVertically()
        ) {
            SplashScreen(composition = composition, progress = animationState.progress)
        }
        AnimatedVisibility(
            visible = !showSplash,
            enter = fadeIn(animationSpec = tween(500)) + slideInVertically(initialOffsetY = { it }),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            InspireScreen()
        }
    }
}
