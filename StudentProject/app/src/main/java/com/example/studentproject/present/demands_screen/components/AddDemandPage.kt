package com.example.studentproject.present.demands_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import com.example.studentproject.R

@Composable
fun AddDemandPage(
    modifier: Modifier = Modifier,
    onClosePage: () -> Unit,
    title: String,
    onTitleChange: (String) -> Unit,
    content: String,
    onContentChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onClear: () -> Unit
) {
    Column() {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(R.string.newDemand),
                fontSize = 30.sp
            )
            Button(
                onClick = onClosePage
            ) {
                Text(stringResource(R.string.closeScreen))
            }
        }
        val focusManager = LocalFocusManager.current
        OutlinedTextField(
            value = title,
            singleLine = true,
            modifier = modifier.fillMaxWidth(),
            onValueChange = onTitleChange,
            label = {Text(stringResource(R.string.title))},
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Next)}
            )
        )
        OutlinedTextField(
            value = content,
            singleLine = false,
            modifier = modifier.fillMaxWidth(),
            onValueChange = onContentChange,
            label = {Text(stringResource(R.string.howCanWeHelpYou))},
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            )
        )
        Row(
          modifier = modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onSubmit
            ) {
                Text(text = stringResource(R.string.submit))
            }
            OutlinedButton(
                onClick = onClear
            ) {
                Text(stringResource(R.string.clean))
            }
        }
    }
}