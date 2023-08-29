/*
 * Created by Younes Megaache on 29/08/2023, 8:26 am
 * Copyright (c) 2023.
 */

package com.younes.example.ui

import AngelCare
import FruitBlend
import HiddenJaguar
import SupremeSky
import DeepPurple500
import WarmFlame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warehouse
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


val colors = listOf(
    SupremeSky,
    AngelCare,
    HiddenJaguar,
    FruitBlend,
)

@Preview
@Composable
fun ColorExample() {
    Box(
        modifier = Modifier.size(200.dp)
            .background(DeepPurple500)
    )
}

/******** gradient ********/

fun Modifier.gradient(
    colorStops: Array<Pair<Float, Color>>? = null
) = if (colorStops != null) this.background(
    brush = Brush.linearGradient(
        *colorStops,
        start = Offset(0f, Float.POSITIVE_INFINITY),
        end = Offset(
            Float.POSITIVE_INFINITY, 0f
        ),
    )
) else this

@Preview
@Composable
fun GradientExample() {
    Box(
        modifier = Modifier.size(200.dp)
            .background(
                brush =  Brush.linearGradient(
                    *WarmFlame,
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(
                        Float.POSITIVE_INFINITY, 0f
                    ),
                )
            )
    )
}

@Composable
fun DashboardAtAGlance(
    values: List<Pair<String, String>> = listOf()
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "At a glance",
            style = MaterialTheme.typography.titleSmall
        )
        LazyVerticalGrid(
            contentPadding = PaddingValues(8.dp),
            columns = GridCells.Fixed(2),
            content = {
                items(values.size) { index ->
                    DashboardStatsCard(
                        modifier = Modifier.padding(12.dp),
                        title = values[index].first,
                        value = values[index].second,
                        colorStops = colors[index]
                    )
                }
            })
    }
}

@Composable
fun DashboardStatsCard(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.Warehouse,
    title: String = "title",
    value: String = "$234",
    colorStops: Array<Pair<Float, Color>>
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 16.dp
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .gradient(colorStops)
                .padding(16.dp)
        ) {
            Image(
                imageVector = icon,
                contentDescription = title
            )
            Spacer(
                Modifier.height(16.dp)
            )
            Column {
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview("default")
@Composable
private fun DefaultPreview() {
    Box(
        Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        DashboardAtAGlance(
            listOf(
                Pair("dubai", "324"),
                Pair("AbuDhabi", "232"),
                Pair("In Transit", "23"),
                Pair("Returns", "1")
            )
        )
    }

}