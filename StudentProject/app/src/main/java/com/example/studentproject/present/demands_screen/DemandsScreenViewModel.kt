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

    init {
        updateDemands()
    }

    fun onOpenAddPage() {
        updatePage(1)
    }

    private fun updatePage(page: Int) {
        _demandsScreenState.update { currentState ->
            currentState.copy(
                screenShouldShow = page
            )
        }
    }

    fun toPage0() {
        updatePage(0)
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
        updatePage(2)
    }
}