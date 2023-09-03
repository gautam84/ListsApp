package com.gautam.listsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gautam.listsapp.ui.theme.ListsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val list = mutableListOf(Example("Title1", "A lot of important data."), Example("Title1", "A lot of important data."), Example("Title1", "A lot of important data."))
                    LazyListApp(list)
                }
            }
        }
    }
}

@Composable
fun LazyListApp(list: List<Example>) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(

            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list.size) {
                ExampleCard(list[it])
            }
        }
    }
}

@Composable
fun ExampleCard(example: Example) {
    Card {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = example.label, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = example.details)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LazyListPreview() {
    val list = mutableListOf(Example("Title1", "A lot of important data."), Example("Title1", "A lot of important data."), Example("Title1", "A lot of important data."))
    LazyListApp(list)
}