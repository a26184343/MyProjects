package com.example.pic.present

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pic.present.theme.PicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {
                    switchPage()
                }
            }
        }
    }
}

@Preview
@Composable
fun pre() {
    PicTheme {
        switchPage()
    }
}