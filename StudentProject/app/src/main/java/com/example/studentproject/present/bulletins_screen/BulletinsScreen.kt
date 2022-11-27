package com.example.studentproject.present.bulletins_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentproject.present.bulletins_screen.components.AddBulletinButton
import com.example.studentproject.present.bulletins_screen.components.AddBulletinPage
import com.example.studentproject.present.bulletins_screen.components.BulletinsList
import com.example.studentproject.present.bulletins_screen.components.SingleBulletinView

@Composable
fun BulletinsScreen(
    user: String,
    bulletinsScreenViewModel: BulletinsScreenViewModel = viewModel()
) {
    val bulletinsScreenState by bulletinsScreenViewModel.bulletinsScreenState.collectAsState()
    when(bulletinsScreenState.screenShouldShow) {
        0 -> {
            BulletinsList(
                existBulletin = bulletinsScreenState.existBulletins,
                onSingleBulletin = {bulletinsScreenViewModel.onSingleBulletin(it)}
            )
            AddBulletinButton(
                onAddBulletin = {bulletinsScreenViewModel.onAddBulletin()}
            )
        }
        1 -> {
            AddBulletinPage(
                onClose = {bulletinsScreenViewModel.onCloseAddPage()},
                content = bulletinsScreenViewModel.tempContent,
                onContentChange = {bulletinsScreenViewModel.onContentChange(it)},
                isAdmin = bulletinsScreenState.isAdmin,
                onAnnounce = {bulletinsScreenViewModel.onAnnounce(author = user)},
                onClean = {bulletinsScreenViewModel.onClean()}
            )
        }
        2 -> {
            SingleBulletinView(
                content = bulletinsScreenViewModel.bulletinData.announceContent,
                author = bulletinsScreenViewModel.bulletinData.announcer,
                date = bulletinsScreenViewModel.bulletinData.announceTime,
                onClose = {bulletinsScreenViewModel.onClose()}
            )
        }
    }
}