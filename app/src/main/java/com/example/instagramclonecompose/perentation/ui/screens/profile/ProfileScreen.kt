package com.example.instagramclonecompose.presentation.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Post
import com.example.instagramclonecompose.perentation.ui.screens.home.uistate.PostUIState
import com.example.instagramclonecompose.perentation.ui.screens.home.uistate.StoriesUIState

@Composable
fun ProfileScreen(postModelUIState: State<PostUIState>, storiesUIState: State<StoriesUIState>,
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
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileDetails()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileActions()
            Spacer(modifier = Modifier.height(16.dp))
            ProfilePhotosGrid(postModelUIState)
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
                androidx.compose.material.IconButton(onClick = { /* Acción para el primer icono */ }) {
                    androidx.compose.material.Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "add",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                androidx.compose.material.IconButton(onClick = { /* Acción para el segundo icono */ }) {
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        ProfileStat("45", "Posts")
        ProfileStat("239", "followers")
        ProfileStat("263", "following")
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
            onClick = { /* Navegar a Búsqueda */ }
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
            onClick = { /* Navegar a Add */ }
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
            onClick = { /* Navegar a Reels */ }
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
fun ProfileStat(count: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .background(Color.Black)
    ) {
        Text(
            text = count,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
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
            onClick = { /* Acción de Editar Perfil */ },
            modifier = Modifier
                .width(170.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(0.dp)), // Bordes menos redondeados
            colors = ButtonDefaults.buttonColors(
                Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Edit Profile")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { /* Acción de Promocionar */ },
            modifier = Modifier
                .width(170.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(0.dp)), // Bordes menos redondeados
            colors = ButtonDefaults.buttonColors(
                Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Share Profile")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { /* Acción de Información */ },
            modifier = Modifier
                .width(45.dp)
                .height(35.dp)
                .clip(RoundedCornerShape(0.dp)), // Bordes menos redondeados
            colors = ButtonDefaults.buttonColors(
                Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_profile), // Reemplaza con tu icono
                contentDescription = "Info Icon",
                modifier = Modifier.size(100.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun ProfilePhotosGrid(postModelUIState: State<PostUIState>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(postModelUIState.value.posts) { post ->
            Image(
                painter = painterResource(id = post.imageUrl), // Asegúrate de que `post` tenga una propiedad `imageResource`
                contentDescription = "Photo",
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(2.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
