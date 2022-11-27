package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studentproject.data.Bulletin

@Composable
fun BulletinsList(
    modifier: Modifier = Modifier,
    existBulletin: List<Bulletin>,
    onSingleBulletin: (Bulletin) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 30.dp, bottom = 78.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(existBulletin) { bulletin ->
            BulletinCard(
                content = bulletin.announceContent,
                date = bulletin.announceTime,
                modifier = modifier
                    .clickable(onClick = { onSingleBulletin(
                        Bulletin(
                            announceContent = bulletin.announceContent,
                            announcer = bulletin.announcer,
                            announceTime = bulletin.announceTime
                        )
                    )}
                )
            )
        }
    }
}