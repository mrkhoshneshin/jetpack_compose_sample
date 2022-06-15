package com.example.compose

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Surface() {
        LazyColumn {
            items(20) {
                ContentItem()
            }
        }
    }
}

@Composable
fun ContentItem() {
    var expanded by remember {
        mutableStateOf(false)
    }
    val expandDp by animateDpAsState(targetValue = if (expanded) 45.dp else 0.dp, animationSpec = spring(
        Spring.DampingRatioMediumBouncy,Spring.StiffnessLow
    ))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = expandDp.coerceAtLeast(0.dp)).background(Color.Green)
    ) {
        Column(modifier = Modifier.width(100.dp)) {
            Text(text = "Hi MohammadJavad")
            Text(text = "Hi This is a goolds;lfksd dsfdsf;ldksj sdf sd;flkdjsf;lsdkjf ;sldkfjsd;lfkjsd;flksjdflksdjfsdflksdjhfsdlkjfhsdfkj")
        }
        OutlinedButton(onClick = {expanded = !expanded}) {
            Text(text = if (expanded) "Show less" else "Show more")
        }
        }
    }