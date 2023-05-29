package br.com.alura.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.core.designsystem.theme.CardBackground
import br.com.alura.core.designsystem.theme.TextColor
import br.com.alura.core.designsystem.theme.VoxfyTheme
import coil.compose.AsyncImage
import kotlin.random.Random

@Composable
fun PlayedCard(
    imageUrl: String,
    contentDescription: String?,
    songTitle: String,
    songDescription: String,
    modifier: Modifier = Modifier,
    songProgression: Float = 0.0f
) {
    Row(
        modifier
            .clip(RoundedCornerShape(10.dp))
            .background(CardBackground)
            .height(72.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            Modifier
                .fillMaxHeight()
                .weight(1.0f),
            placeholder = ColorPainter(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxHeight()
                .padding(
                    horizontal = 20.dp,
                    vertical = 8.dp
                )
                .weight(3.0f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                songTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle.Default.copy(color = TextColor),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                songDescription,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle.Default.copy(color = TextColor),
                fontSize = 12.sp
            )
            LinearProgressIndicator(
                songProgression, Modifier
                    .padding(top = 4.dp)
                    .clip(RoundedCornerShape(50))
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.0f)
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
                songDescription = LoremIpsum(2).values.first(),
                songProgression = Random.nextFloat(),
                modifier = Modifier.height(72.dp)
            )
        }
    }
}