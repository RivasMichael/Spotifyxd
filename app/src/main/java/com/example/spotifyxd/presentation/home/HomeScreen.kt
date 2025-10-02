package com.example.spotifyxd.presentation.home

import android.health.connect.datatypes.units.BloodGlucose
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.spotifyxd.ui.theme.SpotifyxdTheme


private val Bg = Color(0xFF181818)
private val Surface = Color(0xFF282828)
private val Accent = Color(0xFF484848)
private val SpotifyGreen = Color(0xFF1DB954)

data class TrackUi(
    val title: String,
    val artist: String,
    val duracion: String ="3:50",
    val coverUrl: String
)

@Composable
fun HomeScreen() {

    val tracks = listOf(
        TrackUi("Dumbai", "CatrielxPaco", "3:50",
            "https://i.pinimg.com/1200x/3b/98/f7/3b98f795eed9058ce8353ae2c2a2a71d.jpg"),
        TrackUi("Paga Dios", "CatrielxPaco", "3:50",
            "https://i.pinimg.com/1200x/f3/09/d9/f309d9a2cf8ebdc2fa7bda745bd231e2.jpg"),
        TrackUi("Save", "Paco Amoroso", "3:25",
            "https://i.pinimg.com/1200x/ca/c0/45/cac045cadc1625fbb1a18d48ede5b1b3.jpg"),
        TrackUi("No fue amor", "Chita", "3:30",
            "https://i.pinimg.com/1200x/55/b5/32/55b5323196e3bee1a1eda6fdaad7f27c.jpg"),
        TrackUi("DeLuis", "Luis", "3:40",
            "https://i.pinimg.com/736x/91/4f/98/914f98935e7220e53471d4ae7efd648d.jpg"),
        TrackUi("Contando Ovejas", "Wos", "3:20",
            "https://i.pinimg.com/1200x/7b/8e/1f/7b8e1f4949afaf99b6f54555c55865b4.jpg")
    )

    Scaffold(
        containerColor = Bg,
        topBar = {}
    ) { inner ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Bg)
                .padding(inner),
        contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item { HeaderSection() }
            // 2) Lista de canciones
            items(tracks) { track ->
                TrackRow(track)
            }

        }

    }

}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
    ) {
        AsyncImage(
            //model = "data:image/jpeg;base64,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",
            model = ("https://i.pinimg.com/736x/3a/c8/26/3ac82643e3c8d25cb1910b3fb920d832.jpg"),
            contentDescription = "Portada playlist",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Bg.copy(alpha = 0.9f))
                    )
                )

        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                "Today's Top Hits",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                AsyncImage(
                    model = "https://i.pinimg.com/736x/30/6f/6a/306f6a14403921a4d8b4ab53d3c9f2a3.jpg",
                    contentDescription = "Spotify Logo",
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Text(
                    "Spotify · 35,212,210 me gusta · 2h 50m",
                    color = Color.White.copy(alpha = 0.9f),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.weight(1f))

                FilledIconButton(
                    onClick = { /* TODO: reproducir */ },
                    modifier = Modifier.size(52.dp),
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = SpotifyGreen,
                        contentColor = Color.Black
                    )
                ) { Icon(Icons.Filled.PlayArrow, contentDescription = "Play") }

            }

        }

    }


}

@Composable
private fun TrackRow(track: TrackUi) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO: abrir canción */ }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Miniatura (placeholder)
        AsyncImage(
            model = track.coverUrl,
            contentDescription = "${track.title} cover",
            modifier = Modifier
                .size(46.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(track.title, color = Color.White, fontWeight = FontWeight.SemiBold)
            Text(
                track.artist,
                color = Color.White.copy(alpha = 0.75f),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Text(
            track.duracion,
            color = Color.White.copy(alpha = 0.75f),
            style = MaterialTheme.typography.bodySmall
        )

    }
    Divider(color = Color.White.copy(alpha = 0.06f))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    SpotifyxdTheme {
        HomeScreen()
    }
}


