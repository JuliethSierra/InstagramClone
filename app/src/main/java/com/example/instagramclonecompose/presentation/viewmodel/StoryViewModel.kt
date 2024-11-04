package com.example.instagramclonecompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Stories
import com.example.instagramclonecompose.presentation.ui.screens.home.uistate.StoriesUIState
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
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "Greeicy",
                 profileImage = R.drawable.greeicy_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "Ariana",
                profileImage = R.drawable.ariana_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "Netflix",
                profileImage = R.drawable.netflix_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "Juanda",
                profileImage = R.drawable.juanda_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "Espectador",
                profileImage = R.drawable.espectador_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "shashapieterse",
                profileImage = R.drawable.sashapieterse_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "J Balvin",
                profileImage = R.drawable.jbalvin_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "Barbara",
                profileImage = R.drawable.barbara_image,
                isHighlightStory = false
            )
        )
        storiesList.add(
            Stories(
                username = "♥️",
                profileImage = R.drawable.highlight_story1,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "☀️",
                profileImage = R.drawable.highlight_story2,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "💎",
                profileImage = R.drawable.highlight_story6,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "💜",
                profileImage = R.drawable.highlight_story5,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "👨‍👩‍👧‍👦",
                profileImage = R.drawable.highlight_story4,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "😊",
                profileImage = R.drawable.highlight_story3,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "🌟",
                profileImage = R.drawable.highlight_story7,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "🎓",
                profileImage = R.drawable.highlight_story9,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "✨",
                profileImage = R.drawable.highlight_story10,
                isHighlightStory = true
            )
        )
        storiesList.add(
            Stories(
                username = "🏀",
                profileImage = R.drawable.highlight_story8,
                isHighlightStory = true
            )
        )
    }

    fun getStories() {
        _uiState.value = _uiState.value.copy(
            stories = storiesList.filter { !it.isHighlightStory }
        )
    }

    fun getPersonalStories() {
        _uiState.value = _uiState.value.copy(
            stories = storiesList.filter { it.isHighlightStory }
        )
    }
}