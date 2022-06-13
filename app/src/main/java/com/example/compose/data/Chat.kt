package com.example.compose.data

import androidx.annotation.DrawableRes

data class Chat(
    @DrawableRes val profile: Int,
    val text: String
)
