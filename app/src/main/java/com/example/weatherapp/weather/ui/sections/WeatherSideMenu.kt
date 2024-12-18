package com.example.weatherapp.weather.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.R

data class WeatherHistory(
    val title: String,
    val temp: String
)

@Composable
fun WeatherSideMenu(
    onClickSettings: () -> Unit,
    onClickSearch: () -> Unit,
) {
    val history = listOf(
        WeatherHistory(
            title = "Октябрьский",
            temp = "3°"
        ),
        WeatherHistory(
            title = "Октябрьский",
            temp = "3°"
        ),
        WeatherHistory(
            title = "Октябрьский",
            temp = "3°"
        ),
    )
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .systemBarsPadding()
            .fillMaxWidth(fraction = 0.6f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onClickSearch) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF)
                )
            }
            IconButton(onClick = onClickSettings) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_settings),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF)
                )
            }
        }

        LazyColumn {
            items(history) { weather ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            10.dp
                        )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_location),
                            contentDescription = null,
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = weather.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFFFFFFFF)
                        )
                    }
                    Row {
                        AsyncImage(
                            model = R.drawable.ic_cloudy,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(20.dp),
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = weather.temp,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFFFFFFFF)
                        )
                    }

                }
            }
        }
    }
}