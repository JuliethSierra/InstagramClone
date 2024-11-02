package com.example.instagramclonecompose.perentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Stories
import com.example.instagramclonecompose.perentation.ui.screens.home.uistate.StoriesUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StoryViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(StoriesUIState())
    val uiState: StateFlow<StoriesUIState> = _uiState.asStateFlow()

    private val storiesList = arrayListOf<Stories>()

    private var storyCount = 0

    init {
        fillPostList()
    }

    private fun fillPostList() {
        storiesList.add(
            Stories(
                username = "User 0",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 1",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 2",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 3",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 4",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 5",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 6",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 7",
                profileImageUrl = R.drawable.media_photo,
            )
        )
        storiesList.add(
            Stories(
                username = "User 8",
                profileImageUrl = R.drawable.media_photo,
            )
        )
    }

    fun getStories() {
        _uiState.value = _uiState.value.copy(
            stories = storiesList
        )
    }
}