package com.example.rhythm.ui.components

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import com.example.rhythm.R
import com.example.rhythm.ui.model.Song

@Composable
fun SongBar(
    song: Song,
    isPlaying: Boolean = false,
    onClick: () -> Unit = {},
    onControlClick: () -> Unit = {}
) {
    val context = LocalContext.current
    val hasImage = remember(song.uri) { hasAlbumArt(context, song.uri) }

    Column(
        modifier = Modifier.clickable(
            onClick = onClick,
            indication = ripple(bounded = true, color = Color(0xFF1ECCB0)),
            interactionSource = remember { MutableInteractionSource() }
        )) {
        Row(
            modifier = Modifier
                .height(0.3.dp)
                .fillMaxWidth()
                .background(Color.White.copy(0.2f))
        ) {}
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = if (hasImage) song.albumArtUri else R.drawable.dummy_poster,
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    song.title,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    song.artist,
                    color = Color.White.copy(0.5f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W300,
                    lineHeight = 1.sp
                )
            }

            Image(
                painterResource(if (isPlaying) R.drawable.ic_pause_outlined else R.drawable.ic_play_outined),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clickable(onClick = onControlClick)
            )
        }
    }
}

private fun hasAlbumArt(context: Context, albumArtUri: Uri): Boolean {
    return try {
        context.contentResolver.openInputStream(albumArtUri)?.use { true } ?: false
    } catch (e: Exception) {
        false
    }
}

@Preview
@Composable
fun PreviewSongBar() {
    SongBar(
        Song(
            id = 1,
            title = "Tum ho toh",
            artist = "Vishal Mishra",
            data = "",
            uri = "".toUri()
        )
    )
}