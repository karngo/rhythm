package com.example.rhythm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rhythm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongPlayer() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2128))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painterResource(R.drawable.ic_close), contentDescription = null)
            Image(painterResource(R.drawable.ic_menu), contentDescription = null)
        }
        Row(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.White)
        ) {}

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painterResource(R.drawable.dummy_poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    "In hatho mein jabse hai",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        "Full Lyrics",
                        color = Color(0xFF1ECCB0),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W300
                    )
                    Image(
                        painterResource(R.drawable.ic_up_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .background(Color(0xFF1ECCB0), RoundedCornerShape(100))
                            .padding(1.dp)
                            .size(12.dp),
                    )
                }

                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                "Tum ho toh",
                                color = Color.White,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.W500
                            )
                            Text(
                                "Saiyaara - Vishal Mishra",
                                color = Color.White.copy(0.5f),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W400
                            )
                        }
                        Image(
                            painterResource(R.drawable.ic_vert_more),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.5f))
                        )
                    }
                    Column {
                        Slider(
                            value = sliderPosition,
                            onValueChange = { sliderPosition = it },
                            interactionSource = interactionSource,
                            thumb = {
                                Row(
                                    modifier = Modifier
                                        .size(5.dp)
                                        .background(Color(0xFF1ECCB0), CircleShape)
                                ) { }
                            },
                            track = {
                                Row(
                                    modifier = Modifier
                                        .height(1.dp)
                                        .fillMaxWidth()
                                        .background(Color.White.copy(0.3f))
                                ) { }
                            }
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "0.00",
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 10.sp
                            )
                            Text(
                                "0.00",
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(R.drawable.ic_heart),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White.copy(0.5f)),
                    modifier = Modifier.size(32.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(R.drawable.ic_skip_prev),
                        contentDescription = null,
                        modifier = Modifier.size(60.dp)
                    )
                    Image(
                        painterResource(R.drawable.ic_play),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Image(
                        painterResource(R.drawable.ic_skip_next),
                        contentDescription = null,
                        modifier = Modifier.size(60.dp)
                    )
                }
                Image(
                    painterResource(R.drawable.ic_tune),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White.copy(0.5f)),
                    modifier = Modifier.size(32.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painterResource(R.drawable.ic_speaker), contentDescription = null)
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Image(painterResource(R.drawable.ic_shuffle), contentDescription = null)
                    Box {
                        Image(painterResource(R.drawable.ic_repeat), contentDescription = null)
                        Row(
                            modifier = Modifier
                                .background(
                                    Color(0xFF1ECCB0),
                                    CircleShape
                                )
                                .padding(vertical = 0.5.dp, horizontal = 2.dp)
                        ) {
                            Text("1", fontSize = 8.sp, modifier = Modifier.padding(0.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSongPlayer() {
    SongPlayer()
}