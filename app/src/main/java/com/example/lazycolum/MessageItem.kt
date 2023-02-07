package com.example.lazycolum

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lazycolum.ui.theme.Otro


@Composable
fun StateFullListItem(message: Message, isSameSenderAsPrevious: Boolean) {

    var showDateTime by rememberSaveable { mutableStateOf(false) }
    val onClick = { showDateTime = !showDateTime }


    StateLessListItem(message, isSameSenderAsPrevious, showDateTime, onClick)
}


enum class PointyCorner { START, END }

@Composable
fun StateLessListItem(
    message: Message,
    isSameSenderAsPrevious: Boolean,
    showDateTime: Boolean,
    onClick: () -> Unit,
) {

    val alignment = when (message.sender) {
        User.LOCAL -> Alignment.End
        User.REMOTE -> Alignment.Start
    }

    val color = when (message.sender) {
        User.LOCAL -> MaterialTheme.colors.secondary
        User.REMOTE -> Otro
    }

    val pointyCorner =
        if (!isSameSenderAsPrevious)
            when (message.sender) {
                User.LOCAL -> PointyCorner.END
                User.REMOTE -> PointyCorner.START
            } else null


    Column(Modifier.fillMaxWidth()) {

        Card(
            // https://www.youtube.com/watch?v=iZiXpWRIl3U
            Modifier
                .fillMaxWidth(.9f)
                .padding(10.dp)
                .align(alignment),
            elevation = 10.dp,
            shape = RoundedCornerShape(
                bottomStart = 10.dp, bottomEnd = 10.dp,
                topStart = if (pointyCorner == PointyCorner.START) 0.dp else 10.dp,
                topEnd = if (pointyCorner == PointyCorner.END) 0.dp else 10.dp,
            ),
        ) {
            Column(
                Modifier
                    .background(color)
                    .padding(10.dp)
                    .clickable(onClick = onClick),
            ) {
                //Text(text = message.sender.toString())
                Text(text = message.text)
                Spacer(modifier = Modifier.height(4.dp))
                if (showDateTime) {
                    Text(text = message.timestamp.format(formatter), Modifier.align(End))
                    // https://mkyong.com/java8/java-8-how-to-format-localdatetime/
                    // TODO: https://www.flutterclutter.dev/flutter/tutorials/date-format-dynamic-string-depending-on-how-long-ago/2020/229/
                }
            }

        }
    }

}