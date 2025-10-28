package com.example.smartmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.media3.common.util.UnstableApi
import com.example.smartmedia.screen.VideoSummarizationScreen
import com.example.smartmedia.ui.theme.SmartMediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(UnstableApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartMediaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VideoSummarizationScreen(Modifier.padding(innerPadding)) // no need to pass context if not required
                }
            }
        }
    }
}
