package com.example.studentproject.present.profile_screen.components

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.studentproject.R

@Composable
fun LoginBox(
    modifier: Modifier = Modifier,
    user: String,
    onUserChange:(String) -> Unit,
    invalid: Boolean,
    password: String,
    onPasswordChange:(String) -> Unit,
    onLogin:() -> Unit,
    onClean:() -> Unit
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier.padding(top = 100.dp, start = 30.dp, end = 30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = user,
            singleLine = true,
            modifier = modifier.fillMaxWidth(),
            onValueChange = onUserChange,
            label =
            {
                if(!invalid)
                    Text(stringResource(R.string.user))
                 else
                     Text(stringResource(R.string.invalid))
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
            value = password,
            singleLine = true,
            modifier = modifier.fillMaxWidth(),
            onValueChange = onPasswordChange,
            label = { Text(stringResource(R.string.password)) },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = onLogin
            ) {
                Text(stringResource(R.string.login))
            }
            OutlinedButton(
                onClick = onClean
            ) {
                Text(stringResource(R.string.clean))
            }
        }
    }
}