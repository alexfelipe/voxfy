package br.com.alura.feature.home

import br.com.alura.core.model.Song

data class HomeUiState(
    val recentlyPlayedSongs: List<Song> = emptyList(),
    val featuredSongs: List<Song> = emptyList()
)