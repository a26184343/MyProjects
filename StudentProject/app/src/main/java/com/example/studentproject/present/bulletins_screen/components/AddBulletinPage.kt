package com.example.studentproject.present.bulletins_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.studentproject.R

@Composable
fun AddBulletinPage(
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    content: String,
    onContentChange: (String) -> Unit,
    isAdmin: Boolean,
    onAnnounce: () -> Unit,
    onClean: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onClose,
            modifier = modifier.offset(x = 300.dp, y = 0.dp)
        ) {
            Text(
                text = stringResource(R.string.closeScreen)
            )
        }
        OutlinedTextField(
            value = content,
            singleLine = false,
            modifier = modifier.fillMaxWidth(),
            onValueChange = onContentChange,
            label = {
                if(isAdmin) {
                    Text(
                        text = stringResource(R.string.thingsToAnnounce)
                    )
                } else {
                    Text(
                        text = stringResource(R.string.needAdminPermission)
                    )
                }
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
            Button(onClick = onAnnounce) {
                Text(
                    text = stringResource(R.string.announce)
                )
            }
            OutlinedButton(onClick = onClean) {
                Text(
                    text = stringResource(R.string.clean)
                )
            }
        }
    }
}