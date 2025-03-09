package tg.rahimali.filmsapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tg.rahimali.filmsapp.BottomNavigationBar
import tg.rahimali.filmsapp.R
import tg.rahimali.filmsapp.SearchBar
import tg.rahimali.filmsapp.data.FilmItemModel
import tg.rahimali.filmsapp.ui.theme.FilmsAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}


@Composable
@Preview
fun MainScreen(onItemClick: (FilmItemModel) -> Unit = {}) {
    Scaffold(
        bottomBar = { BottomNavigationBar() },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .padding(1.dp)
                    .offset(y=35.dp)
            ) {
                FloatingActionButton(
                    onClick = {},
                    containerColor = colorResource(R.color.black3),
                    modifier = Modifier.size(58.dp),
                    contentColor = Color.White,
                    content = {
                        Icon(
                            painter = painterResource(R.drawable.float_icon),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = colorResource(R.color.blackBackground),

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(color = colorResource(R.color.blackBackground))
        ) {
            Image(
                painter = painterResource(R.drawable.bg1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            MainContent(onItemClick)
        }
    }
}

@Composable
fun MainContent(onItemClick: (FilmItemModel) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top=60.dp, bottom = 100.dp)
    ) {
        Text(
            text = "What would you want to watch ?",
            fontSize = 19.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding( start = 19.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        SearchBar("Search Movies...")
    }
}