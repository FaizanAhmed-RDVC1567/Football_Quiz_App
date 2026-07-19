package com.faizanahmed.footybrain.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class QuizViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState

    fun startQuiz(category: String){
        _uiState.value = QuizUiState(score = 0, currentCategory = category)
    }
}

data class QuizUiState(
    val score: Int = 0,
    val currentCategory: String = ""
)
