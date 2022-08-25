package com.example.composewithviewmodel.present

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composewithviewmodel.R
import com.example.composewithviewmodel.data.getNameList
import com.example.composewithviewmodel.ui.theme.ComposeWithViewModelTheme

@Composable
fun screen(
    modifier:Modifier = Modifier,
    nameList: List<String>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        result()
        search()
        OutlinedButton(
            onClick = {}
        ) {
            Text(text = stringResource(R.string.searchButton))
        }
        nameList(nameList = nameList)
    }
}

@Composable
fun result(modifier:Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.result),
            fontSize = 20.sp
        )
        Text(
            "",
            fontSize = 20.sp
        )
    }
}

@Composable
fun search(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = "",
            singleLine = true,
            onValueChange = {},
            isError = false,
            label = {Text(stringResource(R.string.search))},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {}
            )
        )
    }
}

@Composable
fun nameList(
    modifier: Modifier = Modifier,
    nameList: List<String>
) {
    LazyColumn(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(nameList) {name ->
            nameCard(name = name)
        }
    }
}

@Composable
fun nameCard(
    modifier: Modifier = Modifier,
    name: String
) {
    Text(
        text = "$name",
        fontSize = 20.sp,
        modifier = modifier.clickable(onClick = {})
    )
}

@Composable
fun searchResultDialog(
    modifier: Modifier = Modifier,
    onContinue:() -> Unit
) {
    val activity = (LocalContext.current as Activity)
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {},
        title = {Text(stringResource(R.string.found))},
        text = {Text(stringResource(R.string.index))},
        dismissButton = {
            TextButton(
                onClick = {activity.finish()}
            ) {
                Text(stringResource(R.string.close))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {onContinue()}
            ) {
                Text(stringResource(R.string.contin))
            }
        }
    )
}

@Preview
@Composable
fun pres() {
    ComposeWithViewModelTheme {
        screen(nameList = getNameList)
    }
}