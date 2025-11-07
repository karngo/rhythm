package com.example.rhythm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.rhythm.ui.components.SongBar
import com.example.rhythm.ui.model.Song


@Composable
fun Main(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val songs = remember { mutableStateListOf<Song>() }
    val musicPlayer = remember { ExoPlayer.Builder(context).build() }
    var currentSong: Song? by remember { mutableStateOf(null) }
    var isMusicPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        songs.addAll(getAllSongs(context))
    }

    LaunchedEffect(currentSong) {
        currentSong?.let {
            val mediaItem = MediaItem.fromUri(it.uri)
            musicPlayer.clearMediaItems()
            musicPlayer.setMediaItem(mediaItem)
            musicPlayer.prepare()
            musicPlayer.play()
        }
    }

    DisposableEffect(musicPlayer) {
        val listener = object : Player.Listener {
            override fun onIsPlayingChanged(isPlayingNow: Boolean) {
                isMusicPlaying = isPlayingNow
            }
        }
        musicPlayer.addListener(listener)

        onDispose {
            musicPlayer.removeListener(listener)
            musicPlayer.release()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1F2128))
    ) {
        MusicPermissionHandler {
            SongList(songs, modifier = Modifier.weight(1f)) { song -> currentSong = song }
        }

        currentSong?.let {
            SongBar(
                it,
                isMusicPlaying,
                onClick = {},
                onControlClick = { if (musicPlayer.isPlaying) musicPlayer.pause() else musicPlayer.play() })
        }
    }
}

@Preview
@Composable
fun PreviewMain() {
    Main()
}