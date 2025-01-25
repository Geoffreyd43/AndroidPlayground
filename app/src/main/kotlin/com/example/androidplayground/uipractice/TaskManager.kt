package com.example.androidplayground.uipractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidplayground.R

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        val painter: Painter = painterResource(R.drawable.ic_task_completed)
        Image(
            painter = painter,
            contentDescription = "Task Completed check mark"
        )
        Text(
            text = stringResource(R.string.all_tasks_completed),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp)
        )
        Text(
            text = stringResource(R.string.great_tag),
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp
        )

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TaskManagerPreview(modifier: Modifier = Modifier) {
    TaskManager()
}
