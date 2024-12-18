package com.example.weatherapp.settings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.shared.navigation.AppDestinations

@Composable
fun SettingsScreen(
    navController: NavController
) {
    var selectedLanguage by remember { mutableStateOf("English") }
    var selectedTemperature by remember { mutableStateOf("Celsius") }
    var selectedPressure by remember { mutableStateOf("mm Hg") }
    var selectedWind by remember { mutableStateOf("m/s") }
    var selectedNotification by remember { mutableStateOf("yes") }

    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.navigate(AppDestinations.Main) }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFFFFFFFF)
                )
            }
            Text(
                text = "Settings",
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.headlineMedium
            )
            IconButton(onClick = { navController.navigate(AppDestinations.Search) }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFFFFFFFF)
                )
            }
        }
        DropdownMenuSetting(
            label = "Notification",
            options = listOf("yes", "no"),
            selectedOption = selectedNotification,
            onOptionSelected = { selectedNotification = it }
        )

        DropdownMenuSetting(
            label = "Language",
            options = listOf("English", "Русский"),
            selectedOption = selectedLanguage,
            onOptionSelected = { selectedLanguage = it }
        )

        DropdownMenuSetting(
            label = "Temperature Units",
            options = listOf("Celsius", "Fahrenheit"),
            selectedOption = selectedTemperature,
            onOptionSelected = { selectedTemperature = it }
        )

        DropdownMenuSetting(
            label = "Pressure Units",
            options = listOf("mm Hg", "hPa"),
            selectedOption = selectedPressure,
            onOptionSelected = { selectedPressure = it }
        )

        DropdownMenuSetting(
            label = "Wind Speed Units",
            options = listOf("m/s", "km/h", "knots", "mph"),
            selectedOption = selectedWind,
            onOptionSelected = { selectedWind = it }
        )
    }
}

@Composable
private fun DropdownMenuSetting(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Color(0x1AFFFFFF))
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(15.dp)
        ) {
            Text(
                text = "$label: $selectedOption",
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_expand_right),
                contentDescription = null,
                tint = Color(0xFFFFFFFF)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            shape = MaterialTheme.shapes.extraLarge,
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF4A90E2), // Светло-синий
                            Color(0xFF1C4A7E)  // Темно-синий
                        )
                    )
                ),
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    text = { Text(option) },
                    trailingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_done),
                            contentDescription = null,
                            tint = Color(0xFFFFFFFF)
                        )
                    }
                )
            }
        }
    }
}


