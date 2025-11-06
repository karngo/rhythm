package com.example.rhythm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.rhythm.ui.MusicPermissionHandler
import com.example.rhythm.ui.getAllSongs
import com.example.rhythm.ui.model.Song
import com.example.rhythm.ui.theme.RhythmTheme
import com.example.rhythm.ui.theme.SongList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RhythmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context = LocalContext.current
                    val songs = remember { mutableStateListOf<Song>() }

                    LaunchedEffect(Unit) {
                        songs.addAll(getAllSongs(context))
                    }

                    Box(modifier = Modifier.padding(innerPadding)) {
                        MusicPermissionHandler {
                            SongList(songs)
                        }
                    }
                }
            }
        }
    }
}