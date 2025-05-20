package com.example.tasklite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.tasklite.viewmodel.DesafioTaskViewModel
import com.example.tasklite.ui.theme.TaskLiteTheme
import com.example.tasklite.ui.DesafioTaskListScreen

class MainActivity : ComponentActivity() {
    private val taskViewModel: DesafioTaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskLiteTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    DesafioTaskListScreen(viewModel = taskViewModel) // usar aqui o DesafioTaskListScreen
                }
            }
        }
    }
}

