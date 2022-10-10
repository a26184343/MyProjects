package com.example.studentproject.present.chats_screen.components

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import com.example.studentproject.R

@Composable
fun AddChatPage(
    modifier: Modifier = Modifier,
    title: String,
    onTitleChange: (String) -> Unit,
    titleError: Boolean,
    content: String,
    onContentChange: (String) -> Unit,
    contentError: Boolean,
    onSend: () -> Unit,
    onClean: () -> Unit,
    onClose: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.anythingYouWantToTalk)
        )
        val focusManager = LocalFocusManager.current
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = title,
                singleLine = true,
                modifier = modifier.fillMaxWidth(),
                onValueChange = onTitleChange,
                label = {
                    if(titleError)
                        Text(stringResource(R.string.canNotBeEmpty))
                    else
                    Text(text = stringResource(R.string.title))
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )
            OutlinedTextField(
                value = content,
                singleLine = false,
                modifier = modifier.fillMaxWidth(),
                onValueChange = onContentChange,
                label = {
                    if(contentError)
                        Text(stringResource(R.string.canNotBeEmpty))
                    else
                        Text(text = stringResource(R.string.anythingYouWantToTalk))
                },
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
                    onClick = onSend
                ) {
                    Text(
                        text = stringResource(R.string.share)
                    )
                }
                OutlinedButton(
                    onClick = onClean
                ) {
                    Text(
                        text = stringResource(R.string.clean)
                    )
                }
            }
            Button(
                onClick = onClose,
                modifier = modifier.offset(x = 300.dp, y = 0.dp)
            ) {
                Text(text = stringResource(R.string.closeScreen))
            }
        }
    }
}