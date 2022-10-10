package com.example.studentproject.present.chats_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentproject.present.chats_screen.components.*

@Composable
fun ChatsScreen(
    modifier: Modifier = Modifier,
    user: String,
    chatsScreenViewModel: ChatsScreenViewModel = viewModel()
) {
    val chatsScreenState by chatsScreenViewModel.chatsScreenState.collectAsState()
    when(chatsScreenState.screenShouldShow) {
        0 -> {
            ChatsList(
                existChats = chatsScreenState.existChats,
                onOpenChat = {chatsScreenViewModel.onOpenChat(it)}
            )
            AddChatButton(
                onStartChat = {chatsScreenViewModel.onStartChat(user)}
            )
        }
        1 -> {
            AddChatPage(
                title = chatsScreenViewModel.tempTitle,
                onTitleChange = {chatsScreenViewModel.onTitleChange(it)},
                titleError = chatsScreenState.titleError,
                content = chatsScreenViewModel.tempContent,
                onContentChange = {chatsScreenViewModel.onContentChange(it)},
                contentError = chatsScreenState.contentError,
                onSend = {chatsScreenViewModel.onSend()},
                onClean = {chatsScreenViewModel.onClean()},
                onClose = {chatsScreenViewModel.onClose()}
            )
        }
        2 -> {
            SingleChatView(
                data = chatsScreenViewModel.chatData,
                messages = chatsScreenState.messages,
                onClose = {chatsScreenViewModel.onCloseSingleChat()},
                message = chatsScreenViewModel.tempMessage,
                onMessageChange = {chatsScreenViewModel.onMessageChange(it)},
                onComment = {chatsScreenViewModel.onComment()}
            )
        }
        3 -> {
            LoadingPage()
        }
    }
}