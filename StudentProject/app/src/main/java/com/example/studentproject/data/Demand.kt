package com.example.studentproject.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

data class Demand(
    val title: String = "",
    val content: String = "",
    val author: String = "",
    val date: String = "",
    val solved: Boolean = false
)

fun submitDemand(
    title: String,
    content: String,
    author: String
) {
    val dateFormat = SimpleDateFormat("yyyy.MM.dd G HH.mm:ss z")
    val currentDateAndTime: String = dateFormat.format(Date())
    val database = Firebase.database.reference.child("demands")
    val demandId = database.push().key!!
    val demand = Demand(title, content, author, currentDateAndTime, false)
    database.child(demandId).setValue(demand)
        .addOnCompleteListener {

        }.addOnFailureListener {

        }
}

fun updateDemandsList(): MutableList<Demand> {
    val list = mutableListOf(Demand())
    val database = Firebase.database.reference.child("demands")
    database.addValueEventListener(object: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if(snapshot.exists()) {
                list.clear()
                for(demandShot in snapshot.children) {
                    val demand = demandShot.getValue(Demand::class.java)
                    list.add(demand!!)
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {

        }
    })
    return list
}
