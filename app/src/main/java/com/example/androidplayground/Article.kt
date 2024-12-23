package com.example.androidplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun Article(name: String, modifier: Modifier = Modifier) {
    Column {
        val image: Painter = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = "background image"
        )
        Text(
            text = stringResource(R.string.article_title, name),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.article_intro),
            modifier = Modifier.padding(16.dp, 0.dp)
        )
        Text(
            text = stringResource(R.string.article_body),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArticlePreview() {
        Article(name = "Geoffrey")
}