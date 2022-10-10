package com.example.studentproject.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

data class Chat(
    val date: String = "",
    val host: String = "",
    val title: String = "",
    val content: String = "",
    val key: String = ""
)

fun startChat(
    chatHost: String,
    chatTitle: String,
    chatContent: String
) {
    val dateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH.mm:ss z")
    val currentDateAndTime: String = dateFormat.format(Date())
    val database = Firebase.database.reference.child("chats")
    val chatId = database.push().key!!
    val chat = Chat(currentDateAndTime, chatHost, chatTitle, chatContent, chatId)
    database.child(chatId).setValue(chat)
        .addOnCompleteListener {

        }.addOnFailureListener {

        }
}
