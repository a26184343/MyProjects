package com.example.studentproject.present

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentproject.R
import com.example.studentproject.data.Chat
import com.example.studentproject.present.bulletins_screen.BulletinsScreen
import com.example.studentproject.present.chats_screen.ChatsScreen
import com.example.studentproject.present.demands_screen.DemandsScreen
import com.example.studentproject.present.navigation.navBar
import com.example.studentproject.present.posts_screen.components.ImagePicker
import com.example.studentproject.present.profile_screen.ProfileScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainScreenViewModel: MainScreenViewModel = viewModel()
) {
    val mainScreenState by mainScreenViewModel.mainScreenState.collectAsState()
    when(mainScreenState.whichPageShouldShow) {
        0 -> {
            BulletinsScreen(user = mainScreenState.user)
        }
        1 -> {
            ChatsScreen(user = mainScreenState.user)
        }
        2 -> {ImagePicker()}
        3 -> {DemandsScreen(author = mainScreenState.user)}
        4 -> {
            ProfileScreen(
                user = mainScreenState.user,
                isLogin = mainScreenState.isLogin,
                invalid = mainScreenState.invalidUser,
                onLogin = {mainScreenViewModel.onLogin(it)}
            )
        }
    }
    navBar(
        onChangeToBulletin = {mainScreenViewModel.changeToBulletin()},
        onChangeToChat = {mainScreenViewModel.changeToChat()},
        onChangeToVideo = {mainScreenViewModel.changeToVideo()},
        onChangeToDemand = {mainScreenViewModel.changeToDemand()},
        onChangeToPersonalProfile = {mainScreenViewModel.changeToPersonalProfile()}
    )
}