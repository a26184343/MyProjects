package com.example.studentproject.present

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentproject.R
import com.example.studentproject.data.Bulletin
import com.example.studentproject.data.Chat
import com.example.studentproject.data.NewUser
import com.example.studentproject.present.bulletins_screen.BulletinsScreen
import com.example.studentproject.present.demands_screen.DemandsScreen
import com.example.studentproject.present.navigation.navBar
import com.example.studentproject.present.posts_screen.components.ImagePicker
import com.example.studentproject.present.profile_screen.ProfileScreen
import com.example.studentproject.ui.theme.StudentProjectTheme

@Composable
fun mainScreen(
    modifier: Modifier = Modifier,
    mainScreenViewModel: MainScreenViewModel = viewModel()
) {
    val mainScreenState by mainScreenViewModel.mainScreenState.collectAsState()
    when(mainScreenState.whichPageShouldShow) {
        0 -> {
            BulletinsScreen(user = mainScreenState.user)
        }
        1 -> {chatScreen(
            shouldShowStartChat = mainScreenViewModel.shouldShowStartChat,
            existChat = mainScreenState.existChat,
            onStartChat = {mainScreenViewModel.onStartChat()},
            tempChatTitle = mainScreenViewModel.tempChatTitle,
            onChatTitleChange = {mainScreenViewModel.onChatTitleChange(it)},
            tempChatContent = mainScreenViewModel.tempChatContent,
            onChatContentChange = {mainScreenViewModel.onChatContentChange(it)},
            onSendChat = {mainScreenViewModel.onSendChat()},
            onChatRoomClean = {mainScreenViewModel.onChatRoomClean()},
            onCloseChatRoom = {mainScreenViewModel.onCloseChatRoom()},
        )}
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

@Composable
fun chatScreen(
    modifier: Modifier = Modifier,
    shouldShowStartChat: Boolean,
    existChat: List<Chat>,
    onStartChat:() -> Unit,
    tempChatTitle: String,
    onChatTitleChange:(String) -> Unit,
    tempChatContent: String,
    onChatContentChange:(String) -> Unit,
    onSendChat:() -> Unit,
    onChatRoomClean:() -> Unit,
    onCloseChatRoom:() -> Unit
) {
    if(!shouldShowStartChat) {
        LazyColumn(

        ) {
            items(existChat) { chat ->
                Text(chat.chatTitle)
                Row(

                ) {
                    Text(chat.chatHost)
                    Text(chat.chatTime)
                }
            }
        }
        Button(
            onClick = onStartChat,
            modifier = modifier.padding(top = 570.dp, start = 260.dp, bottom = 60.dp, end = 20.dp)
        ) {
            Text(stringResource(R.string.saySomething))
        }
    }
    else {
        val focusManager = LocalFocusManager.current
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = tempChatTitle,
                singleLine = true,
                modifier = modifier.fillMaxWidth(),
                onValueChange = onChatTitleChange,
                label = {
                        Text(
                            text = stringResource(R.string.title)
                        )
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )
            OutlinedTextField(
                value = tempChatContent,
                singleLine = false,
                modifier = modifier.fillMaxWidth(),
                onValueChange = onChatContentChange,
                label = {
                        Text(text = stringResource(R.string.anythingYouWantToTalk))
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {focusManager.clearFocus()}
                )
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = onSendChat
                ) {
                    Text(
                        text = stringResource(R.string.share)
                    )
                }
                OutlinedButton(
                    onClick = onChatRoomClean
                ) {
                    Text(
                        text = stringResource(R.string.clean)
                    )
                }
            }
            Button(
                onClick = onCloseChatRoom,
                modifier = modifier.offset(x = 300.dp, y = 0.dp)
            ) {
                Text(text = stringResource(R.string.closeScreen))
            }
        }
    }
}

@Composable
fun videoScreen() {
    Text("v")
}

@Composable
fun demandScreen() {
    Text("d")
}


@Preview
@Composable
fun mainScreenPreview() {
    StudentProjectTheme {
        mainScreen()
    }
}