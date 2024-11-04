package com.example.instagramclonecompose.presentation.ui.screens.home.uistate

import com.example.instagramclonecompose.model.Stories

data class StoriesUIState (
    val stories: List<Stories> = emptyList(),
    val isLoading: Boolean = true
)
