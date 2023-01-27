package com.example.lazycolum

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MessagesScreen() {
    MessagesList(messages = messages)
}


// https://www.youtube.com/watch?v=_JO4Xxx0vb0


@Composable
fun MessagesList(messages: List<MyMessage>) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        state = rememberLazyListState(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(messages) { message ->
            MyComponent(message)
        }
    }

}