package com.example.lazycolum

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MyComponent(message: Message) {
    // https://www.youtube.com/watch?v=hWwZ_AuSGfo

    var showDateTime by remember { mutableStateOf(false) }



    Card(  // https://www.youtube.com/watch?v=iZiXpWRIl3U
        Modifier
            .clickable { showDateTime = !showDateTime }
            .padding(5.dp)
            .gravity(if (message.sender == User.USER_1) Alignment.End else Alignment.Start),
        elevation = 10.dp,
        shape = RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp),

    ) {
        Row(
            Modifier
                .background(MaterialTheme.colors.secondary)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier.padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = message.sender.toString())
                Text(text = message.text)
                if (showDateTime) {
                    Text(text = message.timestamp.format(formatter))
                    // https://mkyong.com/java8/java-8-how-to-format-localdatetime/
                    // TODO: https://www.flutterclutter.dev/flutter/tutorials/date-format-dynamic-string-depending-on-how-long-ago/2020/229/
                }
            }

        }
    }

}