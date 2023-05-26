package br.com.alura.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.alura.designsystem.components.PlayedCard
import br.com.alura.designsystem.theme.VoxfyTheme

@Composable
fun HomeScreen(uiState: HomeUiState) {
    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors =
                    listOf(
                        Color(0xFF154580),
                        Color(0xFF041833),
                    )
                )
            )
    ) {
        PlayedCard(
            imageUrl = "https://picsum.photos/1920/1080",
            contentDescription = null,
            songTitle = LoremIpsum(10).values.first(),
            songDesc = LoremIpsum(10).values.first(),
            Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    VoxfyTheme {
        Surface {
            HomeScreen(uiState = HomeUiState())
        }
    }
}