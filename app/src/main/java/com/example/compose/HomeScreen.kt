package com.example.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.data.Chat
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun HomeScreen() {
    LazyColumn {
        items(100) {
            Greeting("MohammadJavad")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun Greeting(name: String = "MohammadJavad") {
    var expanded by remember {
        mutableStateOf(false)
    }
    val expandDp by animateDpAsState(
        targetValue = if (expanded) 45.dp else 1.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(color = MaterialTheme.colors.primary) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = expandDp.coerceAtLeast(0.dp))
                .fillMaxWidth()
        ) {
            Column {
                Text(text = "Welcome")
                Text(text = name)
            }
            OutlinedButton(onClick = { expanded = !expanded }) {
                Text(text = if(expanded) "Show less" else "Show more")
            }
        }
    }
}
