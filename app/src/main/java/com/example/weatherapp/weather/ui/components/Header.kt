package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.weather.data.model.WeatherResponse


@Composable
fun Header(onClick: () -> Unit, weatherResponse: WeatherResponse) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp).statusBarsPadding()
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_menu),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color(0xFFFFFFFF)
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = weatherResponse.location.name,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFFFFFFFF)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_location),
                contentDescription = null,
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(20.dp)
            )
        }
    }

}