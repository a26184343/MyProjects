package com.example.studentproject.present.demands_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentproject.present.demands_screen.components.*

@Composable
fun DemandsScreen(
    modifier: Modifier = Modifier,
    demandsScreenViewModel: DemandsScreenViewModel = viewModel(),
    author: String
) {
    val demandsScreenState by demandsScreenViewModel.demandsScreenState.collectAsState()
    when(demandsScreenState.screenShouldShow) {
        0 -> {
            DemandsList(
                listData = demandsScreenState.existDemands,
                onOpenSingleDemand = {demandsScreenViewModel.onOpenSingleDemand(it)}
            )
            AddDemandButton(
                onAddDemand = {demandsScreenViewModel.onOpenAddPage()},
            )
        }
        1 -> {
            AddDemandPage(
                onClosePage = {demandsScreenViewModel.toPage0()},
                title = demandsScreenViewModel.tempTitle,
                onTitleChange = {demandsScreenViewModel.onTitleChange(it)},
                content = demandsScreenViewModel.tempContent,
                onContentChange = {demandsScreenViewModel.onContentChange(it)},
                onSubmit = {demandsScreenViewModel.onSubmit(author)},
                onClear = {demandsScreenViewModel.onClear()}
            )
        }
        2 -> {
            SingleDemandView(
                title = demandsScreenViewModel.singleDemandData.title,
                content = demandsScreenViewModel.singleDemandData.content,
                author = demandsScreenViewModel.singleDemandData.author,
                createDate = demandsScreenViewModel.singleDemandData.date,
                solved = demandsScreenViewModel.singleDemandData.solved,
                onClose = {demandsScreenViewModel.toPage0()}
            )
        }
    }

}