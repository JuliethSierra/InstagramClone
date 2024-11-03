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
                username = "Andrea Sierra",
                profileImage = R.drawable.profile_image,
            )
        )
        storiesList.add(
            Stories(
                username = "Greeicy",
                 profileImage = R.drawable.greeicy_image,
            )
        )
        storiesList.add(
            Stories(
                username = "Ariana",
                profileImage = R.drawable.ariana_image,
            )
        )
        storiesList.add(
            Stories(
                username = "Netflix",
                profileImage = R.drawable.netflix_image,
            )
        )
        storiesList.add(
            Stories(
                username = "Juanda",
                profileImage = R.drawable.juanda_image,
            )
        )
        storiesList.add(
            Stories(
                username = "Espectador",
                profileImage = R.drawable.espectador_image,
            )
        )
        storiesList.add(
            Stories(
                username = "shashapieterse",
                profileImage = R.drawable.sashapieterse_image,
            )
        )
        storiesList.add(
            Stories(
                username = "J Balvin",
                profileImage = R.drawable.jbalvin_image,
            )
        )
        storiesList.add(
            Stories(
                username = "Barbara",
                profileImage = R.drawable.barbara_image,
            )
        )
    }

    fun getStories() {
        _uiState.value = _uiState.value.copy(
            stories = storiesList
        )
    }
}