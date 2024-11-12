package com.example.instagramclonecompose.presentation.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Post
import com.example.instagramclonecompose.model.Stories
import com.example.instagramclonecompose.presentation.ui.screens.home.uistate.PostUIState
import com.example.instagramclonecompose.presentation.ui.screens.home.uistate.StoriesUIState


@Composable
fun ProfileScreen(
    postModelUIState: State<PostUIState>,
    storiesUIState: State<StoriesUIState>,
    onHomeClick: () -> Unit
) {
    Scaffold(
        topBar = { InstagramTopBar() },
        bottomBar = { InstagramBottomBar(onHomeClick) },
        modifier = Modifier.background(Color.Black)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.Black)
                .verticalScroll(rememberScrollState())
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileDetails()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileActions()
            Spacer(modifier = Modifier.height(16.dp))
            StoriesRow(storiesUIState = storiesUIState)
            ProfilePhotosGrid(posts = postModelUIState.value.posts)
        }
    }
}

@Composable
fun InstagramTopBar() {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            androidx.compose.material.Text(
                text = "julieth_viasus",
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
            Row {
                androidx.compose.material.IconButton(onClick = {  }) {
                    androidx.compose.material.Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "add",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                androidx.compose.material.IconButton(onClick = { }) {
                    androidx.compose.material.Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.Black)
    ) {
        val (profileImage, posts, followers, following) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .constrainAs(profileImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.Crop
        )

        ProfileStat(
            count = "45",
            label = "Posts",
            modifier = Modifier.constrainAs(posts) {
                start.linkTo(profileImage.end, margin = 40.dp)
                top.linkTo(profileImage.top)
                bottom.linkTo(profileImage.bottom)
            }
        )

        ProfileStat(
            count = "239",
            label = "Followers",
            modifier = Modifier.constrainAs(followers) {
                start.linkTo(posts.end, margin = 40.dp)
                top.linkTo(posts.top)
                bottom.linkTo(posts.bottom)
            }
        )

        ProfileStat(
            count = "263",
            label = "Following",
            modifier = Modifier.constrainAs(following) {
                start.linkTo(followers.end, margin = 20.dp)
                top.linkTo(followers.top)
                bottom.linkTo(followers.bottom)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun ProfileStat(count: String, label: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = count, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = label, color = Color.Gray, fontSize = 14.sp)
    }
}
@Composable
fun InstagramBottomBar(onHomeClick: () -> Unit) {
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            icon = {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            },
            selected = true,
            onClick = onHomeClick
        )
        BottomNavigationItem(
            icon = {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            },
            selected = false,
            onClick = {  }
        )
        BottomNavigationItem(
            icon = {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Add",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            },
            selected = false,
            onClick = {  }
        )
        BottomNavigationItem(
            icon = {
                androidx.compose.material.Icon(
                    painter = painterResource(id = R.drawable.reels),
                    contentDescription = "Reels",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
            },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.media_photo),
                        contentDescription = "Profile",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            },
            selected = false,
            onClick = { }
        )
    }
}

@Composable
fun ProfileDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Andrea Sierra",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = "🌸",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ProfileActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(Color.Black),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {  },
            modifier = Modifier
                .width(170.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(
                Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Edit Profile")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .width(170.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(
                Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Share Profile")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .width(45.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(
                Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_profile),
                contentDescription = "Info Icon",
                modifier = Modifier.size(100.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun StoriesRow(storiesUIState: State<StoriesUIState>) {
    LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
        items(storiesUIState.value.stories) { story ->
            StoriesItem(story)
        }
    }
}

@Composable
fun StoriesItem(story: Stories) {
    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = story.profileImage),
                    contentDescription = "Profile",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            androidx.compose.material.Text(
                text = story.username,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
}


@Composable
fun ProfilePhotosGrid(posts: List<Post>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        for (i in posts.indices step 3) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0 until 3) {
                    if (i + j < posts.size) {
                        Image(
                            painter = painterResource(id = posts[i + j].imageUrl),
                            contentDescription = "Photo",
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                                .padding(1.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

