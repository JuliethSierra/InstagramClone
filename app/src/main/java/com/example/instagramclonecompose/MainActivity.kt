package com.example.instagramclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.instagramclonecompose.perentation.viewmodel.PostViewModel
import com.example.instagramclonecompose.perentation.viewmodel.StoryViewModel
import com.example.instagramclonecompose.perentation.ui.screens.home.HomeScreen

class MainActivity : ComponentActivity() {

    private val postViewModel: PostViewModel by viewModels()
    private val storiesViewModel: StoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getPosts()
        getStories()

        setContent {
            val postsState = postViewModel.uiState.collectAsState()
            val storiesState = storiesViewModel.uiState.collectAsState()

            HomeScreen(postModelUIState = postsState, storiesUIState = storiesState)
        }
    }

    private fun getPosts() {
        postViewModel.getPosts()
    }

    private fun getStories() {
        storiesViewModel.getStories()
    }
}



