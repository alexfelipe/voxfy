package br.com.alura.core.model

data class Song(
    val title: String,
    val description: String,
    val genre: String,
    val durationInSeconds: Int,
    val releaseYear: Int,
    val albumPic: String? = null
)