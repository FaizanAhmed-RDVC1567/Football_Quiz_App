package com.faizanahmed.footybrain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(score: Int, onPlayAgain: () -> Unit) {

    /*
    * The Scaffold bit here, is to put some appropriate space between the status bar at
    * the top, and the top part of the app so that the two screens don't mix together,
    * and the user experience becomes better.
    */

    Scaffold(
        topBar = { AppTopBar("View your results") },
        contentWindowInsets = WindowInsets.safeDrawing // respects the status + nav bars
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Final Score: $score", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onPlayAgain) {
                Text("Play Again")
            }
        }
    }
}