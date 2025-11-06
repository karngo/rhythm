package com.example.rhythm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rhythm.R

@Composable
fun SongListItem(text: String, subText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500
            )
            Text(
                subText,
                color = Color.White.copy(0.5f),
                fontSize = 10.sp,
                fontWeight = FontWeight.W300,
                lineHeight = 1.sp
            )
        }
        Image(
            painterResource(R.drawable.ic_tune),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White.copy(0.5f)),
            modifier = Modifier.size(32.dp)
        )
        Image(
            painterResource(R.drawable.ic_vert_more),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.5f))
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewSongListItem() {
    SongListItem("Tum ho toh", "Vishal Mishra")
}