package com.improve10x.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.improve10x.mad.ui.theme.MADTheme
import io.ktor.client.call.body
import io.ktor.client.request.get

class CategoriesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoriesGrid()
                }
            }
        }
    }
}

@Preview
@Composable
fun CategoryItem(
    title: String = "Hoodie",
    imageUrl: String = ""
) {
    var visible by remember {
        mutableStateOf(true)
    }
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable {
                    visible = !visible
                }
        ) {
            AnimatedVisibility(visible = visible) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = imageUrl
                )
            }
            Text(
                text = title,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun SportsItem() {
    CategoryItem("Sports", "")
}

fun generateCategories(): List<Category> {
    return listOf(
        Category(1, "nuevo", "https://i.imgur.com/QkIa5tT.jpeg"),
        Category(2, "Electronics", "https://i.imgur.com/ZANVnHE.jpeg"),
        Category(3, "Furniture", "https://i.imgur.com/Qphac99.jpeg"),
        Category(4, "Shoes", "https://i.imgur.com/qNOjJje.jpeg"),
        Category(5, "Miscellaneous", "https://i.imgur.com/BG8J0Fj.jpg"),
        Category(6, "nuevo", "https://i.imgur.com/QkIa5tT.jpeg"),
        Category(7, "Electronics", "https://i.imgur.com/ZANVnHE.jpeg"),
        Category(8,"Furniture", "https://i.imgur.com/Qphac99.jpeg"),
        Category(9,"Shoes", "https://i.imgur.com/qNOjJje.jpeg"),
        Category(10, "Miscellaneous", "https://i.imgur.com/BG8J0Fj.jpg")

    )
}

@Preview
@Composable
fun CategoriesGrid() {
    val viewModel = CategoryViewModel()
    val categoriesState = viewModel.categories.collectAsState()
    val categories = categoriesState.value
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories) { category ->
            CategoryItem(category.name, category.image)
        }
    }
}



