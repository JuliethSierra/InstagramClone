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
                profileImageUrl = R.drawable.media_photo,
                imageUrl = R.drawable.media_photo,
                description = "Descripción de la publicación 0"
            )
        )
        postList.add(
            Post(
                username = "User 1",
                profileImageUrl = R.drawable.media_photo,
                imageUrl = R.drawable.media_photo,
                description = "Descripción de la publicación 1"
            )
        )
        postList.add(
            Post(
                username = "User 2",
                profileImageUrl = R.drawable.media_photo,
                imageUrl = R.drawable.media_photo,
                description = "Descripción de la publicación 2"
            )
        )
        postList.add(
            Post(
                username = "User 3",
                profileImageUrl = R.drawable.media_photo,
                imageUrl = R.drawable.media_photo,
                description = "Descripción de la publicación 3"
            )
        )
        postList.add(
            Post(
                username = "User 4",
                profileImageUrl = R.drawable.media_photo,
                imageUrl = R.drawable.media_photo,
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