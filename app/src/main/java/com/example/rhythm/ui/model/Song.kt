package com.example.rhythm.ui.model

import android.net.Uri

data class Song(
    val id: Long,
    val title: String,
    val artist: String,
    val data: String,
    val uri: Uri
)