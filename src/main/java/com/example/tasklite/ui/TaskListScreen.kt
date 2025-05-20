package com.example.tasklite.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasklite.viewmodel.DesafioTaskViewModel
import androidx.compose.foundation.layout.Spacer
import com.example.tasklite.ui.TaskItemDesafio

@Composable
fun TaskListScreen (viewModel : DesafioTaskViewModel, modifier : Modifier
= Modifier ) {
    val taskList by viewModel .tasks.collectAsState ()
    var newTaskTitle by remember { mutableStateOf("") }
    Column(modifier = Modifier .fillMaxSize().padding(16.dp)) {
        Text("TaskLite" , fontSize = 24.sp)
        Spacer(Modifier .height(16.dp))
        LazyColumn {
            items(taskList) { task ->
                TaskItemDesafio(
                    task = task,
                    onCheckedChange = { viewModel.onTaskChecked(task.id) },
                    onDelete = { viewModel.onDeleteTask(task.id) }  // <-- aqui
                )
            }
        }
        Spacer(Modifier .height(16.dp))
        Row {
            TextField (
                value = newTaskTitle ,
                onValueChange = { newTaskTitle = it },
                label = { Text("Nova tarefa" ) },
                modifier = Modifier .weight(1f)
            )
            Spacer(Modifier .width(8.dp))
            Button(onClick = {
                viewModel .onAddTask( newTaskTitle )
                newTaskTitle = ""
            }) {
                Text("Adicionar" )
            }
        }
    }
}