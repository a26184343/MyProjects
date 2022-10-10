package com.example.studentproject.present

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studentproject.data.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel: ViewModel() {
    private val _mainScreenState = MutableStateFlow(MainScreenState())
    val mainScreenState: StateFlow<MainScreenState> = _mainScreenState

    init {
        updatePage(4)
    }

    fun changeToBulletin() {
        updatePage(0)
    }

    fun changeToChat() {
        updatePage(1)
    }

    fun changeToVideo() {
        updatePage(2)
    }

    fun changeToDemand() {
        updatePage(3)
    }

    fun changeToPersonalProfile() {
        updatePage(4)
    }

    private fun updatePage(page: Int) {
        _mainScreenState.update { currentState->
            currentState.copy(
                whichPageShouldShow = page
            )
        }
    }

    var shouldShowStartChat by mutableStateOf(false)
        private set

    fun onStartChat() {
        shouldShowStartChat = true
    }

    var tempChatTitle by mutableStateOf("")
        private set

    fun onChatTitleChange(title: String) {
        tempChatTitle = title
    }

    var tempChatContent by mutableStateOf("")
        private set

    fun onChatContentChange(content: String) {
        tempChatContent = content
    }

    fun onSendChat() {
        startChat(
            _mainScreenState.value.user,
            tempChatTitle,
            tempChatContent
        )
        tempChatTitle = ""
        tempChatContent = ""
        updateChat()
    }

    var chatList = mutableListOf(Chat())
        private set

    fun updateChat() {
        val database = Firebase.database.reference.child("chats")
        database.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    chatList.clear()
                    for(chatShot in snapshot.children) {
                        val chat = chatShot.getValue(Chat::class.java)
                        chatList.add(chat!!)
                    }
                }
                _mainScreenState.update { currentState ->
                    currentState.copy(
                        existChat = chatList
                    )
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun onChatRoomClean() {
        tempChatTitle = ""
        tempChatContent = ""
    }

    fun onCloseChatRoom() {
        shouldShowStartChat = false
    }

    private var valid by mutableStateOf(false)

    fun onLogin(user: UserData) {
        val database = Firebase.database.reference
        database.child("users").child(user.user).get().addOnSuccessListener {
            val userData = it.child("password").value.toString()
            if(userData == user.password)
                valid = true
            updateUser(user.user)
        }.addOnFailureListener {

        }
    }

    private fun updateUser(user: String) {
        if(!valid) {
            _mainScreenState.update { current ->
                current.copy(
                    invalidUser = true
                )
            }
        } else {
            _mainScreenState.update { current ->
                current.copy(
                    isLogin = true,
                    user = user
                )
            }
        }
    }
}
