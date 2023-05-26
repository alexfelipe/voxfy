package br.com.alura.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.alura.designsystem.theme.VoxfyTheme
import coil.compose.AsyncImage
import kotlin.random.Random

@Composable
fun PlayedCard(
    imageUrl: String,
    contentDescription: String?,
    songTitle: String,
    songDesc: String,
    modifier: Modifier = Modifier,
    songProgression: Float = 0.0f
) {
    val cardBackground = Color(0xFF365a86)
    Row(
        modifier
            .clip(RoundedCornerShape(10.dp))
            .background(cardBackground)
            .height(72.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            Modifier
                .height(72.dp)
                .weight(1.0f),
            placeholder = ColorPainter(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 8.dp
                )
                .weight(3.0f)
        ) {
            Text(
                songTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                songDesc,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            LinearProgressIndicator(
                songProgression, Modifier
                    .padding(top = 4.dp)
                    .clip(RoundedCornerShape(50))
            )
        }
        Box(
            modifier = Modifier
                .weight(1.0f)
                .height(72.dp)
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                Modifier.align(Alignment.Center),
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play icon"
                )
            }
        }
    }
}

@Preview
@Composable
fun PlayedCardPreview() {
    VoxfyTheme {
        Surface {
            PlayedCard(
                imageUrl = "",
                contentDescription = null,
                songTitle = LoremIpsum(5).values.first(),
                songDesc = LoremIpsum(2).values.first(),
                songProgression = Random.nextFloat()
            )
        }
    }
}