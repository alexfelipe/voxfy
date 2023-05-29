package br.com.alura.feature.home

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.lifecycle.ViewModel
import br.com.alura.core.model.Song
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                recentlyPlayedSongs = generateSongs(10),
                featuredSongs = generateSongs(20)
            )
        }
    }

    private fun generateSongs(numbers: Int) = List(numbers) {
        val title = LoremIpsum(Random.nextInt(2, 20)).values.first()
        val description = LoremIpsum(Random.nextInt(2, 20)).values.first()
        val genre = LoremIpsum(Random.nextInt(2, 20)).values.first()
        val year = Random.nextInt(1990, 2022)
        val widthResolution = Random.nextInt(
            1920,
            2048
        )
        val heightResolution = Random.nextInt(
            1080,
            1440
        )
        Song(
            title = title,
            description = description,
            durationInSeconds = Random.nextInt(60, 600),
            genre = genre,
            releaseYear = year,
            albumPic = "https://picsum.photos/$widthResolution/$heightResolution"
        )
    }

}