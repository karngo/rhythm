package com.example.rhythm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.rhythm.ui.components.SongListItem
import com.example.rhythm.ui.model.Song

@Composable
fun SongList(songs: List<Song>, modifier: Modifier = Modifier, onSongClicked: (Song) -> Unit = {}) {
    Column(modifier = modifier.background(Color(0xFF1F2128))) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Songs", color = Color.White, fontSize = 24.sp)
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = 32.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(songs) { song ->
                SongListItem(
                    song.title,
                    song.artist,
                    modifier = Modifier
                        .clickable(
                            onClick = { onSongClicked(song) },
                            indication = ripple(bounded = true, color = Color(0xFF1ECCB0)),
                            interactionSource = remember { MutableInteractionSource() }
                        )
                        .padding(vertical = 12.dp)
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewSongList() {
    SongList(
        listOf(
            Song(
                id = 1,
                title = "Tum ho toh",
                artist = "Vishal Mishra",
                data = "",
                uri = "".toUri()
            ),
            Song(
                id = 1,
                title = "Tum ho toh",
                artist = "Vishal Mishra",
                data = "",
                uri = "".toUri()
            ),
            Song(
                id = 1,
                title = "Tum ho toh",
                artist = "Vishal Mishra",
                data = "",
                uri = "".toUri()
            ),
            Song(
                id = 1,
                title = "Tum ho toh",
                artist = "Vishal Mishra",
                data = "",
                uri = "".toUri()
            )
        )
    )
}