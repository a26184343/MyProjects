package com.example.studentproject.present.profile_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studentproject.data.login
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ProfileScreenViewModel: ViewModel() {
    private val _profileScreenState = MutableStateFlow(ProfileScreenState())
    val profileScreenState: StateFlow<ProfileScreenState> = _profileScreenState

    var user by mutableStateOf("")
        private set

    fun onUserChange(user: String) {
        this.user = user
    }

    var password by mutableStateOf("")
        private set

    fun onPasswordChange(password: String) {
        this.password = password
    }

    fun onClean() {
        user = ""
        password = ""
    }
}