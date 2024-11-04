package com.example.instagramclonecompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Post
import com.example.instagramclonecompose.presentation.ui.screens.home.uistate.PostUIState
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
                username = "Espectador",
                profileImage = R.drawable.espectador_image,
                imageUrl = R.drawable.post_espectador1,
                description = "Descripción de la publicación 0",
                isMyPost = false
            )
        )
        postList.add(
            Post(
                username = "Espectador",
                profileImage = R.drawable.espectador_image,
                imageUrl = R.drawable.post_espectador2,
                description = "Descripción de la publicación 1",
                isMyPost = false
            )
        )
        postList.add(
            Post(
                username = "Netflix",
                profileImage = R.drawable.netflix_image,
                imageUrl = R.drawable.post_netflix1,
                description = "Descripción de la publicación 2",
                isMyPost = false
            )
        )
        postList.add(
            Post(
                username = "Netflix",
                profileImage = R.drawable.netflix_image,
                imageUrl = R.drawable.post_netflix2,
                description = "Descripción de la publicación 3",
                isMyPost = false
            )
        )
        postList.add(
            Post(
                username = "J Balvin",
                profileImage = R.drawable.jbalvin_image,
                imageUrl = R.drawable.post_jbalvin1,
                description = "Descripción de la publicación 4",
                isMyPost = false
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post1,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post2,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post3,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post4,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post5,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post6,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post7,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post8,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post9,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post10,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post11,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )
        postList.add(
            Post(
                username = "Andrea",
                profileImage = R.drawable.profile_image,
                imageUrl = R.drawable.my_post12,
                description = "Descripción de la publicación 4",
                isMyPost = true
            )
        )

    }

    fun getPosts() {
        _uiState.value = _uiState.value.copy(
            posts = postList.filter { !it.isMyPost }
        )
    }

    fun getPersonalPosts() {
        _uiState.value = _uiState.value.copy(
            posts = postList.filter { it.isMyPost }
        )
    }
}