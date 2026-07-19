package com.faizanahmed.footybrain.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryScreen(onCategorySelected: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { onCategorySelected("players") }, modifier = Modifier.fillMaxWidth()) {
            Text("Players")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onCategorySelected("clubs") }, modifier = Modifier.fillMaxWidth()) {
            Text("Clubs")
        }
    }
}