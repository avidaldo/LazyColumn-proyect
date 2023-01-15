package com.example.lazycolum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lazycolum.ui.theme.LazyColumTheme
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MessagesScreen()
                }
            }
        }
    }

}

@Composable
fun MessagesScreen() {
    //val scrollState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Probando") },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowDropDown, null)
                    }
                })
        },
    ) {
        Box(Modifier.padding(it)) {
            Lista(messages = messages)
        }
    }
}


// https://www.youtube.com/watch?v=_JO4Xxx0vb0


@Composable
fun Lista(messages: List<MyMessage>) {
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


@Composable
fun MyComponent(message: MyMessage) {
    // https://www.youtube.com/watch?v=hWwZ_AuSGfo

    var showDetails by remember { mutableStateOf(false) }

    Card(  // https://www.youtube.com/watch?v=iZiXpWRIl3U
        Modifier
            .clickable { showDetails = !showDetails }
            .padding(5.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(Modifier
            .background(MaterialTheme.colors.secondary)
            .padding(10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary),
                alignment = Alignment.Center,
            )
            Spacer(Modifier.width(8.dp))
            Column(Modifier.padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = message.title)
                Text(text = message.body)
                if (showDetails) {
                    Text(text = message.time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    // https://mkyong.com/java8/java-8-how-to-format-localdatetime/
                    // TODO: https://www.flutterclutter.dev/flutter/tutorials/date-format-dynamic-string-depending-on-how-long-ago/2020/229/
                }
            }

        }
    }

}

data class MyMessage(val title: String, val body: String, val time: LocalDateTime = now())
