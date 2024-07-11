package com.kolaysoft.portfolip_app_jetpack.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kolaysoft.portfolip_app_jetpack.data.model.PortfiloModel

@Preview
@Composable
 fun PortfolioCard(modifier: Modifier = Modifier) {
    val portfolioShowState = remember { mutableStateOf(false) }

    Surface(modifier = modifier.fillMaxSize()) {
        Card(
            modifier = modifier
                .width(200.dp)
                .height(400.dp)
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.Yellow)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PortfolioProfileImage(modifier)
                Divider(
                    modifier = modifier
                        .padding(20.dp)
                        .width(250.dp), color = Color.Black, thickness = 0.3.dp
                )
                PortfolioPersonInfo(modifier)
                Button(onClick = {
                    portfolioShowState.value = !portfolioShowState.value
                }) {
                    Text(text = "Portfolio")
                }
                PortfolioProject(isShown = portfolioShowState.value)
            }
        }
    }
}


@Preview
@Composable
private fun PortfolioProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        shadowElevation = 10.dp
    ) {

        Icon(
            imageVector = Icons.Default.Android,
            contentDescription = "",
            modifier = modifier
                .clip(CircleShape)
                .background(Color.Green)
                .padding(20.dp)
        )
    }
}

@Preview
@Composable
private fun PortfolioPersonInfo(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(5.dp)) {
        Text(
            text = "Kubilay Direk",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "@kdirek", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun PortfolioProject(modifier: Modifier = Modifier, isShown: Boolean = false) {
    if (isShown) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Surface(
                modifier = modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ) {
                PortfolioProjectItem(
                    data = listOf(
                        PortfiloModel(
                            "Google MLKit Android Apps",
                            "All Android Applications using Google MLKit"
                        ),
                        PortfiloModel(
                            "Turkish Airlines Assistant App",
                            "With our open API platform, we provide you the chance to reach, test and use Turkish Airlines’s digital services."
                        ),
                        PortfiloModel(
                            "Nves",
                            "Daily, special & more readable news with NEWS API Android Kotlin"
                        ), PortfiloModel(
                            "Google MLKit Android Apps",
                            "All Android Applications using Google MLKit"
                        ),
                        PortfiloModel(
                            "Turkish Airlines Assistant App",
                            "With our open API platform, we provide you the chance to reach, test and use Turkish Airlines’s digital services."
                        ),
                        PortfiloModel(
                            "Nves",
                            "Daily, special & more readable news with NEWS API Android Kotlin"
                        )

                    )
                )
            }
        }
    }
}

@Composable
fun PortfolioProjectItem(modifier: Modifier = Modifier, data: List<PortfiloModel>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    modifier = modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(10.dp)
                ) {
                    PortfolioProfileImage(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = modifier
                            .padding(10.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item.portfolioName ?: "",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(text = item.portfolioDescription ?: "", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}