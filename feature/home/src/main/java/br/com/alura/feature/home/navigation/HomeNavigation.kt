package br.com.alura.feature.home.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.alura.feature.home.HomeScreen
import br.com.alura.feature.home.HomeViewModel

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen() {
    composable(homeRoute) {
        val viewModel = hiltViewModel<HomeViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        HomeScreen(uiState)
    }
}