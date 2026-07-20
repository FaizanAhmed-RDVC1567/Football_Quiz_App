package com.faizanahmed.footybrain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faizanahmed.footybrain.viewmodel.QuizViewModel

@Composable
fun QuizScreen(category: String, viewModel: QuizViewModel, onFinished: (Int) -> Unit) {
    val state by viewModel.uiState.collectAsState()

    /*
    * The Scaffold bit here, is to put some appropriate space between the status bar at
    * the top, and the top part of the app so that the two screens don't mix together,
    * and the user experience becomes better.
    */

    Scaffold(
        topBar = { AppTopBar("Choose an answer") },
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
            Text("Quiz for $category", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Score: ${state.score}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onFinished(state.score) }) {
            Text("Finish Quiz")
            }
        }
    }
}