package com.improve10x.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.improve10x.mad.ui.theme.MADTheme

class CategoriesTopDownActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoriesScreen()
                }
            }
        }
    }


}

@Composable
fun CategoriesScreen() {
    Column {
        Text(text = "All Categories")
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(categoriesList()){
                item -> CategoryItemUi(item.imageUrl, item.title)

            }
        }
    }
}

@Composable
fun CategoryItemUi(imageUrl: String, title: String){
    Card {
        Column {
            AsyncImage(model = imageUrl, contentDescription = title)
            Text(text = title)
        }
    }
}

data class CategoryTopDownItem(
    val imageUrl : String,
    val title : String
)

fun categoriesList(): List<CategoryTopDownItem> {
    return listOf(
        CategoryTopDownItem( "https://i.imgur.com/QkIa5tT.jpeg", "nuevo"),
        CategoryTopDownItem( "https://i.imgur.com/ZANVnHE.jpeg", "Electronics"),
        CategoryTopDownItem( "https://i.imgur.com/Qphac99.jpeg", "Furniture"),
        CategoryTopDownItem( "https://i.imgur.com/qNOjJje.jpeg", "Shoes"),
        CategoryTopDownItem( "https://i.imgur.com/BG8J0Fj.jpg", "Miscellaneous"),
        CategoryTopDownItem( "https://i.imgur.com/QkIa5tT.jpeg", "nuevo"),
        CategoryTopDownItem( "https://i.imgur.com/ZANVnHE.jpeg", "Electronics"),
        CategoryTopDownItem( "https://i.imgur.com/Qphac99.jpeg", "Furniture"),
        CategoryTopDownItem( "https://i.imgur.com/qNOjJje.jpeg", "Shoes"),
        CategoryTopDownItem( "https://i.imgur.com/BG8J0Fj.jpg", "Miscellaneous")

    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MADTheme {
        Greeting("Android")
    }
}