package com.improve10x.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.improve10x.mad.ui.theme.MADTheme

class CountWaterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountWaterCompose()
                }
            }
        }
    }
}

@Preview
@Composable
fun CountWaterCompose() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        if(count > 0) {
            TaskCompose()
            Text(text = "You've had $count glasses.")
        }
        CounterActions(onAddClicked = {
            count++
        }, onClearClicked = {
            count = 0
        })
    }
}

@Composable
fun CounterActions(onAddClicked: () -> Unit, onClearClicked: () -> Unit) {
    Row {
        Button(onClick = {
            onAddClicked()
        }) {
            Text(text = "Add one")
        }
        Button(onClick = {
            onClearClicked()
        }) {
            Text(text = "Clear Water Count")
        }
    }
}

@Composable
fun TaskCompose() {
    var showTask by remember {
        mutableStateOf(true)
    }
    if(showTask) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TaskWalkCompose(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close Button",
                modifier = Modifier
                    .clickable {
                        showTask = false
                    }
            )
        }
    }
}

@Composable
fun TaskWalkCompose(modifier: Modifier) {
    Text(
        text = "Have your taken your 15 min walktoday?",
        modifier = modifier
    )
}







