package com.example.rhythm.ui

import android.graphics.BitmapFactory
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.example.rhythm.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun Album() {
    val context = LocalContext.current
    val fallbackColor = 0xFF1ECCB0
    val imageId = remember { R.drawable.dummy_poster2 }
    var dominantColor by remember { mutableStateOf(Color(fallbackColor)) }

    LaunchedEffect(imageId) {
        withContext(Dispatchers.Default) {
            val bitmap = BitmapFactory.decodeResource(context.resources, imageId)
            val palette = Palette.from(bitmap).generate()
            val colorInt = palette.getDominantColor(fallbackColor.hashCode())
            dominantColor = Color(colorInt)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2128))
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    dominantColor,
                                    Color.Transparent
                                )
                            )
                        )
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Image(
                        painterResource(imageId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 70.dp)
                            .clip(RoundedCornerShape(8.dp)),
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            painterResource(R.drawable.ic_heart),
                            contentDescription = null,
                            modifier = Modifier
                                .border(BorderStroke(1.dp, Color.White.copy(0.1f)), CircleShape)
                                .padding(12.dp)
                                .alpha(0.7f)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Image(
                            painterResource(R.drawable.ic_play_outined),
                            contentDescription = null,
                            modifier = Modifier
                                .background(Color(0xFF1ECCB0).copy(0.7f), CircleShape)
                                .padding(4.dp)
                                .size(40.dp)
                                .alpha(0.7f)
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        "Saiyaara",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        "2025 - Hindi Album - Various Artists",
                        color = Color.White.copy(0.5f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(R.drawable.ic_download),
                            contentDescription = null,
                            modifier = Modifier
                                .border(BorderStroke(1.dp, Color.White.copy(0.1f)), CircleShape)
                                .padding(8.dp)
                                .alpha(0.7f)
                                .size(14.dp)
                        )
                        Image(
                            painterResource(R.drawable.ic_upload),
                            contentDescription = null,
                            modifier = Modifier
                                .border(BorderStroke(1.dp, Color.White.copy(0.1f)), CircleShape)
                                .padding(5.dp)
                                .alpha(0.7f)
                                .size(20.dp)
                        )
                        Text(
                            "122,122,322 Plays",
                            color = Color.White.copy(0.5f),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.W300
                        )
                    }
                }
            }

            items(20) {
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
                            "Tum ho toh",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500
                        )
                        Text(
                            "Vishal Mishra",
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
        }
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(R.drawable.ic_left_chevron),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.Black.copy(0.4f), CircleShape)
                        .padding(4.dp)
                        .size(32.dp)
                )
                Image(
                    painterResource(R.drawable.ic_vert_more),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.Black.copy(0.4f), CircleShape)
                        .padding(4.dp)
                        .size(32.dp)
                )
            }
            Row(
                modifier = Modifier
//                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlbum() {
    Album()
}
