package com.improve10x.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.improve10x.mad.ui.theme.MADTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Preview
@Composable
fun HttpStatusCodeButton(
    code: String = "200",
    onStatusCodeClicked: (code: String) -> Unit = {}) {
    Button(
        onClick = {
            onStatusCodeClicked(code)
        },
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(text = code)
    }
}


@Preview
@Composable
fun FirstRow(onStatusCodeClicked: (code: String) -> Unit = {}) {
    Row(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        HttpStatusCodeButton(code = "200", onStatusCodeClicked)
        HttpStatusCodeButton(code = "201", onStatusCodeClicked)
        HttpStatusCodeButton(code = "202", onStatusCodeClicked)
    }
}

@Preview
@Composable
fun SecondRow(onStatusCodeClicked: (code: String) -> Unit = {}) {
    Row {
        HttpStatusCodeButton(code = "400", onStatusCodeClicked)
        HttpStatusCodeButton(code = "401", onStatusCodeClicked)
        HttpStatusCodeButton(code = "408", onStatusCodeClicked)
    }
}

@Preview
@Composable
fun ThirdRow(onStatusCodeClicked: (code: String) -> Unit = {}) {
    Row {
        HttpStatusCodeButton(code = "403", onStatusCodeClicked)
        HttpStatusCodeButton(code = "404", onStatusCodeClicked)
        HttpStatusCodeButton(code = "405", onStatusCodeClicked)
    }
}

@Preview
@Composable
fun HttpCodeGrid(onStatusCodeClicked: (code: String) -> Unit = {}) {
    Column {
        FirstRow(onStatusCodeClicked)
        SecondRow(onStatusCodeClicked)
        ThirdRow(onStatusCodeClicked)
    }
}

@Preview
@Composable
fun HttpCodeImage(imageUrl: String = "https://vadivelu.anoram.com/jpg/404") {
    AsyncImage(
        model = imageUrl,
        contentDescription = imageUrl,
        modifier = Modifier
            .fillMaxSize())
}

@Preview
@Composable
fun Screen() {
    Column {
        val viewModel = HttpCodesViewModel()
        val imageUrlState = viewModel.imageUrl.collectAsState()
        val imageUrl = imageUrlState.value
        HttpCodeGrid(viewModel::onStatusCodeClicked)
        HttpCodeImage(imageUrl)
    }
}

class HttpCodesViewModel : ViewModel() {

    private val _imageUrl = MutableStateFlow<String>("")
    val imageUrl: StateFlow<String> = _imageUrl

    fun onStatusCodeClicked(code: String) {
        _imageUrl.value = "https://vadivelu.anoram.com/jpg/$code"
    }
}