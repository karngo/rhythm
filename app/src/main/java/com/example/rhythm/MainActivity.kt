package com.example.rhythm

import android.net.Uri
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
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.rhythm.ui.MusicPermissionHandler
import com.example.rhythm.ui.SongList
import com.example.rhythm.ui.getAllSongs
import com.example.rhythm.ui.model.Song
import com.example.rhythm.ui.theme.RhythmTheme

class MainActivity : ComponentActivity() {
    lateinit var musicPlayer: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        musicPlayer = ExoPlayer.Builder(this).build()

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
                            SongList(songs) { song -> playMusic(song.uri) }
                        }
                    }
                }
            }
        }
    }

    private fun playMusic(uri: Uri) {
        val mediaItem = MediaItem.fromUri(uri)
        musicPlayer.clearMediaItems()
        musicPlayer.setMediaItem(mediaItem)
        musicPlayer.prepare()
        musicPlayer.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.release()
    }
}