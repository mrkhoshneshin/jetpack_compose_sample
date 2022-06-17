package com.example.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun HomeScreen() {
    ComposeTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            SearchBar(Modifier)
            SportCourcesSection()
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
        leadingIcon = {Icon(imageVector = Icons.Default.Search, contentDescription = null)},
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        placeholder = { Text(stringResource(id = R.string.place_holder_search))},
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(10.dp)
            .heightIn(min = 56.dp)
    )
}

@Composable
fun SportCourcesSection() {

}