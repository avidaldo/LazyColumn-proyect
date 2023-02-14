package com.example.lazycolum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MessagesScreen() {
    Scaffold(
        topBar = {
            TopAppBar() {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Imagen contacto",
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary),
                    alignment = Alignment.Center,
                )
                Text(text = "Andrey Breslav")
            }
        }
    ) {
        Box(modifier = Modifier.padding(paddingValues = it)) {
            MessagesList(messages = messagesWithChangeOfSenderIndicator)
        }
    }
}



