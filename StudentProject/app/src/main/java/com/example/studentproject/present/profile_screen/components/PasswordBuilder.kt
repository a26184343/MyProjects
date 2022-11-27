package com.example.studentproject.present.profile_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.example.studentproject.R

@Composable
fun PasswordBuilder(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
    originInt: String,
    hash: String,
    hashInt: String,
    resultInt: String,
    result: String,
    onClose: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            singleLine = true,
            label = { Text(stringResource(R.string.textHere)) },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            )
        )
        Text(originInt)
        Text(hash)
        Text(hashInt)
        Text(resultInt)
        Text(result)
        Button(
            onClick = onClose
        ) {
            Text(stringResource(R.string.closeScreen))
        }
    }
}