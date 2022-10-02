package com.example.studentproject.present.profile_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentproject.data.UserData
import com.example.studentproject.present.profile_screen.components.LoginBox
import com.example.studentproject.present.profile_screen.components.UserInfoBox

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    user: String,
    isLogin: Boolean,
    invalid: Boolean,
    onLogin: (UserData) -> Unit,
    profileScreenViewModel: ProfileScreenViewModel = viewModel()
) {
    val profileScreenState by profileScreenViewModel.profileScreenState.collectAsState()
    if(!isLogin) {
        LoginBox(
            user = profileScreenViewModel.user,
            onUserChange = {profileScreenViewModel.onUserChange(it)},
            invalid = invalid,
            password = profileScreenViewModel.password,
            onPasswordChange = {profileScreenViewModel.onPasswordChange(it)},
            onLogin = {onLogin(UserData(
                profileScreenViewModel.user,
                profileScreenViewModel.password
            ))},
            onClean = {profileScreenViewModel.onClean()}
        )
    } else {
        UserInfoBox(
            user = user
        )
    }
}