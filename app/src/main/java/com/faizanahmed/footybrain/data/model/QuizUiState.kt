package com.faizanahmed.footybrain.data.model

data class QuizUiState (
    val score: Int = 0,
    val currentCategory: String = "",
    val currentQuestion: QuizQuestion = QuizQuestion(
        id = 1,
        text = "Sample question?",
        options = listOf("A", "B", "C", "D")
    )
)