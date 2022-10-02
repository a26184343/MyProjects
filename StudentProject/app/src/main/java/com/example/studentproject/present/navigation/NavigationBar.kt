package com.example.studentproject.present.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentproject.R
import com.example.studentproject.ui.theme.StudentProjectTheme

@Composable
fun navBar(
    modifier: Modifier = Modifier,
    onChangeToBulletin:() -> Unit,
    onChangeToChat:() -> Unit,
    onChangeToDemand:() -> Unit,
    onChangeToVideo:() -> Unit,
    onChangeToPersonalProfile:() -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        bulletinAreaButton(changeToBulletin = onChangeToBulletin)
        chatAreaButton(changeToChat = onChangeToChat)
        videoPostAreaButton(changeToVideo = onChangeToVideo)
        demandAreaButton(changeToDemand = onChangeToDemand)
        personalProfileAreaButton(changeToPersonalProfile = onChangeToPersonalProfile)
    }
}

@Composable
fun bulletinAreaButton(
    modifier: Modifier = Modifier,
    changeToBulletin:() -> Unit
) {
    Text(
        text = stringResource(R.string.bulletinAreaButton),
        fontSize = 20.sp,
        modifier = modifier.clickable(onClick = changeToBulletin)
    )
}

@Composable
fun chatAreaButton(
    modifier: Modifier = Modifier,
    changeToChat:() -> Unit
) {
    Text(
        text = stringResource(R.string.chatAreaButton),
        fontSize = 20.sp,
        modifier = modifier.clickable(onClick = changeToChat)
    )
}

@Composable
fun videoPostAreaButton(
    modifier: Modifier = Modifier,
    changeToVideo:() -> Unit
) {
    Text(
        text = stringResource(R.string.videoPostAreaButton),
        fontSize = 20.sp,
        modifier = modifier.clickable(onClick = changeToVideo)
    )
}

@Composable
fun demandAreaButton(
    modifier: Modifier = Modifier,
    changeToDemand:() -> Unit
) {
    Text(
        text = stringResource(R.string.demandAreaButton),
        fontSize = 20.sp,
        modifier = modifier.clickable(onClick = changeToDemand)
    )
}

@Composable
fun personalProfileAreaButton(
    modifier: Modifier = Modifier,
    changeToPersonalProfile:() -> Unit
) {
    Text(
        text = stringResource(R.string.personalProfileAreaButton),
        fontSize = 20.sp,
        modifier = modifier.clickable(onClick = changeToPersonalProfile)
    )
}



@Preview
@Composable
fun navPreview() {
    StudentProjectTheme {
    }
}