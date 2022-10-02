package com.example.studentproject.present.posts_screen.components

import android.content.res.Resources
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun SelectImageButton() {

}

@Composable
fun ImagePicker(
    modifier: Modifier = Modifier
) {
    var imageUri = remember {mutableStateOf<Uri?>(null)}
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri.value = uri
    }
    val placeHolderImage = ""
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(context)
                    .crossfade(false)
                    .data(imageUri.value?:placeHolderImage)
                    .build(),
                filterQuality = FilterQuality.High
            ),
            contentDescription = null,
            modifier = modifier.size(128.dp)
        )
        Button(
            onClick = {launcher.launch("images/*")}
        ) {
            Text("Upload image")
        }
    }
}