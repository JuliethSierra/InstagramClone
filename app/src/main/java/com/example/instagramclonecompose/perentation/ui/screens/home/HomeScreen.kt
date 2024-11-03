package com.example.instagramclonecompose.perentation.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramclonecompose.model.Post
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.model.Stories
import com.example.instagramclonecompose.perentation.ui.screens.home.uistate.PostUIState
import com.example.instagramclonecompose.perentation.ui.screens.home.uistate.StoriesUIState

@Composable
fun HomeScreen(postModelUIState: State<PostUIState>, storiesUIState: State<StoriesUIState>, onProfileClick: () -> Unit) {
    Scaffold(
        topBar = { InstagramTopBar() },
        bottomBar = { InstagramBottomBar(onProfileClick) },
        modifier = Modifier.background(Color.Black)
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            item {
                StoriesRow(storiesUIState)
            }

            items(postModelUIState.value.posts) { post ->
                PostItem(post)
            }
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
            Text(
                text = "Instagram",
                color = Color.White,
                style = MaterialTheme.typography.h5
            )
            Row {
                IconButton(onClick = { /* Acción para el primer icono */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                IconButton(onClick = { /* Acción para el segundo icono */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = "Message",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun InstagramBottomBar(onProfileClick: () -> Unit) {
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            },
            selected = true,
            onClick = { /* Navegar a Home */ }
        )
        BottomNavigationItem(
            icon = {
                Icon(
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
                Icon(
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
                Icon(
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
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "Profile",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            },
            selected = false,
            onClick = onProfileClick
        )


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
        modifier = Modifier.padding(10.dp), // Margen a la derecha entre historias
        verticalAlignment = Alignment.CenterVertically // Alinear elementos verticalmente
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // Centrar el contenido dentro de la columna
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
            Text(
                text = story.username, // Muestra el nombre de la historia
                color = Color.White, // Ajusta el color del texto
                modifier = Modifier.padding(8.dp) // Margen superior entre la imagen y el texto
            )
        }

    }
}


@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Black)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = post.profileImage),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = post.username,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp),
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /* Acción del ícono extra */ },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.options),
                    contentDescription = "More Options",
                    tint = Color.White, // Ícono en blanco
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = post.imageUrl),
            contentDescription = "Post Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            IconButton(onClick = { /* Acción de Me gusta */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "Like",
                    tint = Color.White, // Ícono en blanco
                    modifier = Modifier.size(20.dp)
                )
            }
            IconButton(onClick = { /* Acción de Comentar */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.message),
                    contentDescription = "Comment",
                    tint = Color.White, // Ícono en blanco
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* Acción de Compartir */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = "Share",
                    tint = Color.White, // Ícono en blanco
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Text(
            text = post.description,
            color = Color.White
        )
    }
}
