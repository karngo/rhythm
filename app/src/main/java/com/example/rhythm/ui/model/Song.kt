package com.example.rhythm.ui.model

import android.net.Uri
import androidx.core.net.toUri

data class Song(
    val id: Long,
    val title: String,
    val artist: String,
    val data: String,
    val uri: Uri,
    val album: String = "",
    val albumArtUri: Uri = "".toUri(),
    val duration: Long = 0
)