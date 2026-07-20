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

    /*
    * The Scaffold bit here, is to put some appropriate space between the status bar at
    * the top, and the top part of the app so that the two screens don't mix together,
    * and the user experience becomes better.
    */

    Scaffold(
        topBar = { AppTopBar("Choose a category) },
        contentWindowInsets = WindowInsets.safeDrawing // respects the status + nav bars
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
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
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onCategorySelected("stadiums") }, modifier = Modifier.fillMaxWidth()) {
                Text("Stadiums")
            }
        }
    }
}