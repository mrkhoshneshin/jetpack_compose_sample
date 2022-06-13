package com.example.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.compose.data.Chat
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun HomeScreen() {
    ChatSection(
        listOf(
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ), Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ), Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            ),
            Chat(
                R.drawable.icon,
                "this is a text wrote by mohammadjavad khoshneshin and it's my first course of android jetpack compose and you can contact me with sending an email to mohammadjavadKhoshneshin@gmail.com"
            )


        )
    )
}

@Composable
fun ChatSection(chats: List<Chat>) {
    LazyColumn(modifier = Modifier.padding(15.dp)) {
        items(chats.size) {
            ChatItem(chat = chats[it])
        }
    }
}

@Composable
fun ChatItem(chat: Chat) {
    var selected by remember {
        mutableStateOf(false)
    }
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = chat.text,
            modifier = Modifier
                .clip(CircleShape)
                .size(32.dp)
                .border(if(selected) 1.dp else 0.dp, Color.Green, CircleShape)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = Modifier.clickable { selected = !selected }
        ) {
            Text(
                text = "Halino",
                color = if (selected) Color.Blue else Color.Black,
                fontWeight = FontWeight.Bold
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = chat.text,
                    color = if (selected) Color.Blue else Color.Black,
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}
