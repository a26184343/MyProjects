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

    fun makePassword(password: String) {
        val origin = "ssofjiwwe"
        val originCharArr = origin.toCharArray()
        var originIntArr = IntArray(26)
        val hash = "abcdefghijklmnopqrstuvwxyz"
        var hashCharArr = hash.toCharArray()
        var hashIntArr = IntArray(26)
        var i = 0
        for(c in originCharArr) {
            originIntArr[++i - 1] = c.toInt()
        }
        for(j in originIntArr)
            print("$j ")
        println()
        i = 0
        for(c in hashCharArr) {
            hashIntArr[++i - 1] = c.toInt()
        }
        for(j in hashIntArr)
            print("$j ")
        println()
        var result = IntArray(26)
        for(j in 0..25) {
            result[j] = originIntArr[j] xor hashIntArr[j]
        }
        for(j in result)
            print("$j ")
        println()
        var resultString: String = ""
        for(j in result)
            resultString += j.toChar()
        //println(resultString)
    }
}