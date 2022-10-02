package com.example.studentproject.present.bulletins_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studentproject.data.Bulletin
import com.example.studentproject.data.announce
import com.example.studentproject.data.updateBulletinsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

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
        announce(author, tempContent)
        updateBulletins()
        tempContent = ""
    }

    var bulletins = mutableListOf(Bulletin())

    private fun updateBulletins() {
        bulletins = updateBulletinsList()
        _bulletinsScreenState.update { cur ->
            cur.copy(
                existBulletins = bulletins
            )
        }
    }

    fun onClean() {
        tempContent = ""
    }

    var bulletinData by mutableStateOf(Bulletin())

    fun onSingleBulletin(bulletin: Bulletin) {
        bulletinData = bulletin
        onOpenSingle()
    }

    private fun onOpenSingle() {
        updatePage(2)
    }
}