package tg.rahimali.filmsapp

import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BottomMenuItem(
    val label: String,
    val icon: Painter
)

@Composable
@Preview
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}


@Composable
fun BottomNavigationBar() {
    val bottomItems = bottomMenuList()
    val context = LocalContext.current.applicationContext
    var selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomAppBar(
        tonalElevation = 3.dp,
        contentColor = Color.White,
        containerColor = colorResource(R.color.black3)
    ) {
        bottomItems.forEachIndexed {index, bottomMenuItem ->
            if (index == 2) {
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {},
                    enabled = false
                )
            }

            NavigationBarItem(
                selected = (selectedItem == bottomMenuItem.label),
                onClick = {
                    selectedItem = bottomMenuItem.label
                    Toast.makeText(context, bottomMenuItem.label, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = bottomMenuItem.label,
                        modifier = Modifier.height(20.dp).width(20.dp)
                    )
                },
                label = {
                    Text(
                        text = bottomMenuItem.label,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(top = 10.dp, bottom = 4.dp)
                    )
                },
                alwaysShowLabel = true,
                enabled = true
            )
        }
    }
}

@Composable
fun bottomMenuList(): List<BottomMenuItem> {
    return listOf(
        BottomMenuItem(
            label = "Home",
            icon = painterResource(R.drawable.btn_1)
        ),
        BottomMenuItem(
            label = "Profile",
            icon = painterResource(R.drawable.btn_4)
        ),
        BottomMenuItem(
            label = "Support",
            icon = painterResource(R.drawable.btn_3)
        ),
        BottomMenuItem(
            label = "Settings",
            icon = painterResource(R.drawable.btn_2)
        )
    )
}

