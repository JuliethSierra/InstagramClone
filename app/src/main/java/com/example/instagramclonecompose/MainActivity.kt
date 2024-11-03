package com.example.instagramclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramclonecompose.perentation.viewmodel.PostViewModel
import com.example.instagramclonecompose.perentation.viewmodel.StoryViewModel
import com.example.instagramclonecompose.perentation.ui.screens.home.HomeScreen
import com.example.instagramclonecompose.presentation.ui.screens.profile.ProfileScreen

import com.example.instagramclonecompose.ui.theme.InstagramCloneComposeTheme

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

            val navController = rememberNavController()
            InstagramCloneComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = "posts"
                ) {
                    composable("posts") {
                        HomeScreen(
                            postModelUIState = postsState,
                            storiesUIState = storiesState,
                            onProfileClick = {
                                navController.navigate("Profile")
                            }
                        )
                    }

                    composable("Profile") {
                        ProfileScreen(
                            onHomeClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }

        }
    }

    private fun getPosts() {
        postViewModel.getPosts()
    }

    private fun getStories() {
        storiesViewModel.getStories()
    }
}



