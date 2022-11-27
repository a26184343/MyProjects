package com.example.studentproject.present.bulletins_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studentproject.data.Bulletin
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

class BulletinsScreenViewModel: ViewModel() {
    private val _bulletinsScreenState = MutableStateFlow(BulletinsScreenState())
    val bulletinsScreenState: StateFlow<BulletinsScreenState> = _bulletinsScreenState

    init {
        updateBulletins()
    }

    fun onAddBulletin() {
        updatePage(1)
    }

    private fun updatePage(page: Int) {
        _bulletinsScreenState.update { cur ->
            cur.copy(
                screenShouldShow = page
            )
        }
    }

    fun onCloseAddPage() {
        updatePage(0)
    }

    var tempContent by mutableStateOf("")
        private set

    fun onContentChange(content: String) {
        tempContent = content
    }

    fun onAnnounce(author: String) {
        if(author == "" || author != "admin" || tempContent == "") {
            _bulletinsScreenState.update {cur ->
                cur.copy(
                    isAdmin = false
                )
            }
            return
        }
        val dateFormat = SimpleDateFormat("yyyy.MM.dd G 'at' HH.mm:ss z")
        val date: String = dateFormat.format(Date())
        val database = Firebase.database.reference.child("bulletins")
        val announcementId = database.push().key!!
        val announcement = Bulletin(date, author, tempContent)
        database.child(announcementId).setValue(announcement)
            .addOnCompleteListener {

            }.addOnFailureListener {

            }
        updateBulletins()
        onClean()
    }

    var bulletins = mutableListOf(Bulletin())

    private fun updateBulletins() {
        val database = Firebase.database.reference.child("bulletins")
        database.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                bulletins.clear()
                if(snapshot.exists()) {
                    for(data in snapshot.children) {
                        val bulletin = data.getValue(Bulletin::class.java)
                        bulletins.add(bulletin!!)
                    }
                    _bulletinsScreenState.update {cur->
                        cur.copy(
                            existBulletins = bulletins
                        )
                    }
                    updatePage(0)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun onClean() {
        tempContent = ""
        _bulletinsScreenState.update {cur ->
            cur.copy(
                isAdmin = true
            )
        }
    }

    var bulletinData by mutableStateOf(Bulletin())

    fun onSingleBulletin(bulletin: Bulletin) {
        bulletinData = bulletin
        onOpenSingle()
    }

    private fun onOpenSingle() {
        updatePage(2)
    }

    fun onClose() {
        onClean()
        updatePage(0)
    }
}