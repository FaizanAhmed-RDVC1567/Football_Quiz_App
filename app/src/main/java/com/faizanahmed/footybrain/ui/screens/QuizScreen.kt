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

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Quiz for $category", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Score: ${state.score}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onFinished(state.score) }) {
            Text("Finish Quiz")
        }
    }
}