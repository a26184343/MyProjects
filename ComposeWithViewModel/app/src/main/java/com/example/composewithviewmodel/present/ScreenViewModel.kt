package com.example.composewithviewmodel.present

import androidx.lifecycle.ViewModel
import com.example.composewithviewmodel.data.ScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScreenViewModel : ViewModel() {
    private val _screenState = MutableStateFlow(ScreenUiState())
    val screenState: StateFlow<ScreenUiState> = _screenState.asStateFlow()
}