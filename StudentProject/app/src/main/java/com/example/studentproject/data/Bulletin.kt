package com.example.studentproject.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

data class Bulletin(
    val announceTime: String = "",
    val announcer: String = "",
    val announceContent: String = ""
)