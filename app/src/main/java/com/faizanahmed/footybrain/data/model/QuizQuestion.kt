package com.faizanahmed.footybrain.data.model

data class QuizQuestion (
    val id: Int,
    val text: String,
    val options: List<String>,
    val imageRes: Int? = null  // The null means text-only question
)