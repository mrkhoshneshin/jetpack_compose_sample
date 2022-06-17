package com.example.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.compose.data.AlignBodyItem
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun HomeScreen() {
    ComposeTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBar(Modifier)
            AlignYourBodySection(
                listOf(
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                    AlignBodyItem("Session", R.drawable.icon),
                )
            )
            FavoriteCollection()
        }
    }
}

@Composable
fun FavoriteCollection() {

}

@Composable
fun SearchBar(modifier: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        placeholder = { Text(stringResource(id = R.string.place_holder_search)) },
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodySection(items: List<AlignBodyItem>) {
    LazyRow(contentPadding = PaddingValues(start = 24.dp, end = 24.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items.size) {
            AlignYourBodyItem(title = items[it].title, image = items[it].image)
        }
    }
}

@Composable
fun AlignYourBodyItem(title: String, @DrawableRes image: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(text = title, modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp))
    }
}