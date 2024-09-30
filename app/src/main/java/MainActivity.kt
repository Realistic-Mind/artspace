package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.background

data class Artwork(
    val imageRes: Int,
    val artist: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {  // Appliquer le thème personnalisé
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // Liste des œuvres d'art avec leurs images et artistes
    val artworks = listOf(
        Artwork(R.drawable.art1, "Peach Mokoko"),
        Artwork(R.drawable.captainamerica_03, "Alex Ross"),
        Artwork(R.drawable.art3, "Eduardo Mello")
    )

    // Gestion de l'état pour savoir quelle œuvre d'art est actuellement affichée
    var currentArtworkIndex by remember { mutableStateOf(0) }
    val currentArtwork = artworks[currentArtworkIndex]

    // Structure de la mise en page avec Column et Row
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)  // Utiliser la couleur de fond du thème ici
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Affichage de l'image
        ArtworkImage(imageRes = currentArtwork.imageRes)

        // Affichage du nom de l'artiste avec le nouveau style
        Text(
            text = currentArtwork.artist,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge // Utilisation du style comics
        )

        // Espace entre l'image, le texte et le bouton
        Spacer(modifier = Modifier.height(24.dp))

        // Bouton permettant de passer à l'œuvre suivante
        Button(
            onClick = {
                currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Voir l'œuvre suivante", style = MaterialTheme.typography.labelLarge) // Style de texte pour les boutons
        }
    }
}

@Composable
fun ArtworkImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}