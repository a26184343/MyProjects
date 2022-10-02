package com.example.studentproject.present.demands_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.studentproject.data.Demand
import com.example.studentproject.data.submitDemand
import com.example.studentproject.data.updateDemandsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DemandsScreenViewModel: ViewModel() {
    private val _demandsScreenState = MutableStateFlow(DemandsScreenState())
    val demandsScreenState: StateFlow<DemandsScreenState> = _demandsScreenState

    var currentPage by mutableStateOf(0)
        private set

    fun onOpenAddPage() {
        if(currentPage != 1) currentPage = 1
        updatePage()
    }

    private fun updatePage() {
        _demandsScreenState.update { currentState ->
            currentState.copy(
                screenShouldShow = currentPage
            )
        }
    }

    fun toPage0() {
        currentPage = 0
        updatePage()
    }

    var tempTitle by mutableStateOf("")

    fun onTitleChange(title: String) {
        tempTitle = title
    }

    var tempContent by mutableStateOf("")

    fun onContentChange(content: String) {
        tempContent = content
    }

    fun onSubmit(author: String) {
        submitDemand(tempTitle, tempContent, author)
        updateDemands()
        tempTitle = ""
        tempContent = ""
    }

    var demandsList = mutableListOf(Demand())

    private fun updateDemands() {
        demandsList = updateDemandsList()
        _demandsScreenState.update { currentState ->
            currentState.copy(
                existDemands = demandsList
            )
        }
    }

    fun onClear() {
        tempTitle = ""
        tempContent = ""
    }

    var singleDemandData by mutableStateOf(Demand())

    fun onOpenSingleDemand(demand: Demand) {
        singleDemandData = demand
        openSingleDemandPage()
    }

    private fun openSingleDemandPage() {
        currentPage = 2
        updatePage()
    }
}