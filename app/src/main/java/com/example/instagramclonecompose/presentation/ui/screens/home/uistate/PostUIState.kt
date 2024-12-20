package com.example.instagramclonecompose.presentation.ui.screens.home.uistate

import com.example.instagramclonecompose.model.Post

data class PostUIState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = true
)
