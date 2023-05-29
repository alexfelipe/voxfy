package br.com.alura.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.core.designsystem.theme.MainBackgroundColor
import br.com.alura.core.designsystem.theme.TextColor
import br.com.alura.core.designsystem.theme.VoxfyTheme
import br.com.alura.core.model.Song
import br.com.alura.core.ui.components.FeaturedCard
import br.com.alura.core.ui.components.PlayedCard
import kotlin.random.Random

@Composable
fun HomeScreen(
    uiState: HomeUiState
) {
    val featuredSongs = uiState.featuredSongs
    val recentlyPlayedSongs = uiState.recentlyPlayedSongs
    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = MainBackgroundColor
            )
            .verticalScroll(rememberScrollState())
    ) {
        RecentlyPlayed(
            title = "Tocados recentemente",
            songs = recentlyPlayedSongs
        )
        FeaturedSongs(
            title = "Hipsters Ponto Tech",
            songs = featuredSongs.shuffled().take(6)
        )
        FeaturedSongs(
            title = "Músicas novas",
            songs = featuredSongs.shuffled().take(6)
        )
    }
}

@Composable
private fun FeaturedSongs(
    title: String,
    songs: List<Song>
) {
    Column {
        Text(
            text = title,
            Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            style = TextStyle.Default.copy(TextColor),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(songs) { song ->
            FeaturedCard(
                imageUrl = song.albumPic,
                contentDescription = null,
                songTitle = song.title,
                songDescription = song.description,
                Modifier
                    .height(300.dp)
                    .width(200.dp)
            )
        }
    }
}

@Composable
private fun RecentlyPlayed(
    title: String,
    songs: List<Song>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            style = TextStyle.Default.copy(TextColor),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            Modifier
                .fillMaxWidth()
                .heightIn(max = 150.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(songs) { song ->
                PlayedCard(
                    imageUrl = song.albumPic,
                    contentDescription = null,
                    songTitle = song.title,
                    songDescription = song.description,
                    Modifier
                        .requiredHeight(72.dp)
                        .width(350.dp),
                    songProgression = Random.nextFloat()
                )
            }
        }
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