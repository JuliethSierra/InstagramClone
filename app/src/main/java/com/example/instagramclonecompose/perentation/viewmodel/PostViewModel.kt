package com.example.instagramclonecompose.perentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Post
import com.example.instagramclonecompose.perentation.ui.screens.home.uistate.PostUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PostViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(PostUIState())
    val uiState: StateFlow<PostUIState> = _uiState.asStateFlow()

    private val postList = arrayListOf<Post>()

    private var postCount = 0

    init {
        fillPostList()
    }

    private fun fillPostList() {
        postList.add(
            Post(
                username = "User 0",
                profileImage = R.drawable.espectador_image,
                imageUrl = R.drawable.post_espectador1,
                description = "Descripción de la publicación 0"
            )
        )
        postList.add(
            Post(
                username = "User 1",
                profileImage = R.drawable.espectador_image,
                imageUrl = R.drawable.post_espectador2,
                description = "Descripción de la publicación 1"
            )
        )
        postList.add(
            Post(
                username = "User 2",
                profileImage = R.drawable.netflix_image,
                imageUrl = R.drawable.post_netflix1,
                description = "Descripción de la publicación 2"
            )
        )
        postList.add(
            Post(
                username = "User 3",
                profileImage = R.drawable.netflix_image,
                imageUrl = R.drawable.post_netflix2,
                description = "Descripción de la publicación 3"
            )
        )
        postList.add(
            Post(
                username = "User 4",
                profileImage = R.drawable.jbalvin_image,
                imageUrl = R.drawable.post_jbalvin1,
                description = "Descripción de la publicación 4"
            )
        )
    }

    fun getPosts() {
        _uiState.value = _uiState.value.copy(
            posts = postList
        )
    }
}