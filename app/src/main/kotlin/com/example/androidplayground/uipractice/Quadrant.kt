package com.example.androidplayground.uipractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidplayground.R

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                color = Color(0xFFEADDFF),
                title = stringResource(R.string.text_composable_title),
                body = stringResource(R.string.text_composable_body),
                modifier = modifier.weight(1f)
            )
            QuadrantCard(
                color = Color(0xFFD0BCFF),
                title = stringResource(R.string.image_composable_title),
                body = stringResource(R.string.image_composable_body),
                modifier = modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantCard(
                color = Color(0xFFB69DF8),
                title = stringResource(id = R.string.row_composable_title),
                body = stringResource(id = R.string.row_composable_body),
                modifier = modifier.weight(1f)
            )
            QuadrantCard(
                color = Color(0xFFF6EDFF),
                title = stringResource(id = R.string.column_composable_title),
                body = stringResource(id = R.string.column_composable_body),
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    color: Color,
    title: String,
    body: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .weight(1f)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview(modifier: Modifier = Modifier) {
    Quadrant()
}
