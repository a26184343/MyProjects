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

fun announce(
    announcer: String,
    announceContent: String
) {
    val dateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH.mm:ss z")
    val currentDateAndTime: String = dateFormat.format(Date())
    val database = Firebase.database.reference.child("bulletins")
    val announcementId = database.push().key!!
    val announcement = Bulletin(currentDateAndTime, announcer, announceContent)
    database.child(announcementId).setValue(announcement)
        .addOnCompleteListener {

        }.addOnFailureListener {

        }
}

fun updateBulletinsList(): MutableList<Bulletin> {
    val list = mutableListOf(Bulletin())
    val database = Firebase.database.reference.child("bulletins")
    database.addValueEventListener(object: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if(snapshot.exists()) {
                list.clear()
                for(data in snapshot.children) {
                    val bulletin = data.getValue(Bulletin::class.java)
                    list.add(bulletin!!)
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {

        }
    })
    return list
}