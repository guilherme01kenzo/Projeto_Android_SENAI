package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var showIcons by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE0F2F1)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Mó",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Analise e Desenvolvimento de Sistemas",
                fontSize = 18.sp,
                color = Color(0xFF388E3C),
                textAlign = TextAlign.Center
            )
        }

        Button(onClick = { showIcons = !showIcons }) {
            Text(if (showIcons) "Esconder Contatos" else "Mostrar Contatos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (showIcons) {
            Column(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .verticalScroll(rememberScrollState()), // Adicionado scroll vertical
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ContactInfo(icon = R.drawable.ic_telefone, info = "+55 (11) 12345-6789")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_twitter, info = "@eu.mathzxs")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_email, info = "Math.foda@zika.com")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_instagram, info = "@insta_fake")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_facebook, info = "@face_fake")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_linkedin, info = "@linked_fake")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_youtube, info = "@youtube_fake")
                Spacer(modifier = Modifier.height(8.dp))
                ContactInfo(icon = R.drawable.ic_discord, info = "@discord_fake")
            }
        } else {
            Spacer(modifier = Modifier.height(32.dp)) //Para manter o layout consistente quando os icons forem escondidos.
        }

    }
}

@Composable
fun ContactInfo(icon: Int, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = info)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}