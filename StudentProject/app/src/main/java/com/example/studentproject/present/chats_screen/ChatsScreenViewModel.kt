package com.example.studentproject.present.chats_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studentproject.data.Chat
import com.example.studentproject.data.Message
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.*

class ChatsScreenViewModel: ViewModel() {
    private val _chatsScreenState = MutableStateFlow(ChatsScreenState())
    val chatsScreenState: StateFlow<ChatsScreenState> = _chatsScreenState

    init {
        updateChats()
    }

    var user by mutableStateOf("")

    fun onStartChat(user: String) {
        this.user = user
        updatePage(1)
    }

    private fun updatePage(page: Int) {
        _chatsScreenState.update { current ->
            current.copy(
                screenShouldShow = page
            )
        }
    }

    var tempTitle by mutableStateOf("")

    fun onTitleChange(title: String) {
        tempTitle = title
    }

    var tempContent by mutableStateOf("")

    fun onContentChange(content: String) {
        tempContent = content
    }

    fun onSend() {
        if(tempTitle == "") {
            _chatsScreenState.update{ cur ->
                cur.copy(
                    titleError = true
                )
            }
            return
        }
        if(tempContent == "") {
            _chatsScreenState.update{ cur ->
                cur.copy(
                    contentError = true
                )
            }
            return
        }
        val dateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH.mm:ss z")
        val currentDateAndTime: String = dateFormat.format(Date())
        val database = Firebase.database.reference
        val chatId = database.child("chats").push().key!!
        val chat = Chat(
            date = currentDateAndTime,
            host = user,
            title = tempTitle,
            content = tempContent,
            key = chatId
        )
        database.child("chats").child(chatId).setValue(chat)
            .addOnCompleteListener {

            }.addOnFailureListener {

            }
        onClean()
    }

    fun onClean() {
        tempTitle = ""
        tempContent = ""
        _chatsScreenState.update {cur ->
            cur.copy(
                titleError = false,
                contentError = false
            )
        }
    }

    fun onClose() {
        updateChats()
    }

    fun onComment() {
        val dateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH.mm:ss z")
        val date: String = dateFormat.format(Date())
        val database = Firebase.database.reference
            .child("messages")
            .child(path)
        val message = Message(
            message = tempMessage,
            user = user,
            date = date
        )
        database.push().setValue(message)
            .addOnCompleteListener {
            }.addOnFailureListener {

            }
        updateMessage()
        tempMessage = ""
    }

    var messages = mutableListOf(Message())

    private fun updateMessage() {
        updatePage(3)
        val database = Firebase.database.reference
            .child("messages")
            .child(path)
        database.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                messages.clear()
                for(data in snapshot.children) {
                    val message = data.getValue(Message::class.java)
                    messages.add(message!!)
                }
                _chatsScreenState.update {cur->
                    cur.copy(
                        messages = messages
                    )
                }
                updatePage(2)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    var chatData by mutableStateOf(Chat())
    var path by mutableStateOf("")

    fun onOpenChat(chat: Chat) {
        chatData = chat
        path = chat.date.replace('.', 'e')
        updateMessage()
    }

    var chats = mutableListOf(Chat())

    private fun updateChats(){
        val database = Firebase.database.reference.child("chats")
        database.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    chats.clear()
                    for(data in snapshot.children) {
                        val chat = data.getValue(Chat::class.java)
                        chats.add(chat!!)
                    }
                    _chatsScreenState.update{ cur ->
                        cur.copy(
                            existChats = chats
                        )
                    }
                    updatePage(0)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun onCloseSingleChat() {
        updatePage(0)
    }

    var tempMessage by mutableStateOf("")

    fun onMessageChange(message: String) {
        tempMessage = message
    }
}