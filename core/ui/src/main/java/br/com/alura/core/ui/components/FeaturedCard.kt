package br.com.alura.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun FeaturedCard(
    imageUrl: String,
    contentDescription: String?,
    songTitle: String,
    songDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .background(CardBackground, RoundedCornerShape(10.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            Modifier
                .clip(RoundedCornerShape(5))
                .height(150.dp)
                .fillMaxWidth(),
            placeholder = ColorPainter(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Text(
            text = songTitle,
            style = TextStyle.Default.copy(color = TextColor),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = songDescription,
            style = TextStyle.Default.copy(color = TextColor),
            fontSize = 12.sp,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun FeaturedCardPreview() {
    VoxfyTheme {
        FeaturedCard(
            imageUrl = "",
            contentDescription = null,
            LoremIpsum(30).values.first(),
            LoremIpsum(30).values.first()
        )
    }
}