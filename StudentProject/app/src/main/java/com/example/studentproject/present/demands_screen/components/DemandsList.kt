package com.example.studentproject.present.demands_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studentproject.data.Demand

@Composable
fun DemandsList(
    modifier: Modifier = Modifier,
    listData: List<Demand>,
    onOpenSingleDemand: (Demand) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listData) { item ->
            DemandCard(
                title = item.title,
                date = item.date,
                solved = item.solved,
                modifier =  modifier
                    .clickable(onClick ={onOpenSingleDemand(
                            Demand(
                                item.title,
                                item.content,
                                item.author,
                                item.date,
                                item.solved
                            )
                        )}
                    )
            )
        }
    }
}