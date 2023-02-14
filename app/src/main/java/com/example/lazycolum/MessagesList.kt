package com.example.lazycolum

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// https://www.youtube.com/watch?v=_JO4Xxx0vb0
// https://developer.android.com/codelabs/jetpack-compose-basics#6

@Composable
fun MessagesList(messages: List<MessageWithChangeOfSenderIndicator>) {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        // state = rememberLazyListState(),
    ) {

        items(messages) { message ->
            StateFullListItem(message,message.isSenderChanged)
        }
    }

}