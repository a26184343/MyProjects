package com.example.studentproject.data

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

data class NewUser(
    val account: String? = null,
    val password: String? = null
)

data class UserData(
    val user: String = "",
    val password: String = ""
)

fun enroll(user: String, password: String) {
    val database = FirebaseDatabase.getInstance().getReference("users")
    val nUserId = database.push().key!!
    val nUser = NewUser(user, password)
    database.child(nUserId).setValue(nUser)
        .addOnCompleteListener {

        }.addOnFailureListener {

        }
}

fun login(user: String, password: String) {
    val database = Firebase.database.reference
    database.child("users").child(user).get().addOnSuccessListener {
        val userData = it.child("password").value.toString()
    }.addOnFailureListener {

    }
}