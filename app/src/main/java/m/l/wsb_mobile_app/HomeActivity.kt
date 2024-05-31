package m.l.wsb_mobile_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import m.l.wsb_mobile_app.model.Task
import m.l.wsb_mobile_app.ui.theme.Wsb_mobile_appTheme
import m.l.wsb_mobile_app.util.StorageOperations

var taskList = mutableListOf<Task>()

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskList = StorageOperations.readTaskList(this).toMutableList()

        val task = intent.getSerializableExtra("task") as? Task
        task?.let {
            Toast.makeText(this, "Task created!", Toast.LENGTH_LONG).show()
            taskList.add(it)

            StorageOperations.writeTaskList(this, taskList)
        }

        setContent {
            HomeView()
        }
    }

    @Composable
    fun TaskListView() {
        val context = LocalContext.current

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                text = "Task List",
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 20.dp).align(Alignment.CenterHorizontally),
            )
            Divider()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = taskList) { task ->
                    Card(
                        colors = CardDefaults.cardColors(containerColor = task.colorType.color),
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
                    ) {
                        Row {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = task.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = task.description
                                )
                            }
                            Column(modifier = Modifier.padding(8.dp)) {
                                IconButton(
                                    onClick = {
                                        removeTask(task.id)

                                        val intent = Intent(context, HomeActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    },
                                    modifier = Modifier.size(23.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Delete task."
                                    )
                                }
                                IconButton(
                                    onClick = {
                                        val intent = Intent(context, UpdateActivity::class.java)
                                        intent.putExtra("task_id", task.id)
                                        startActivity(intent)
                                        finish()
                                    },
                                    modifier = Modifier.size(23.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit task."
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun HomeView() {
        val context = LocalContext.current

        Box(modifier = Modifier.fillMaxSize()) {
            if (taskList.isEmpty()) {
                Text(
                    text = "Empty task list.",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                TaskListView()
            }

            FloatingActionButton(
                onClick = {
                    val intent = Intent(context, TaskActivity::class.java)
                    startActivity(intent)
                    finish()
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Task")

            }
        }
    }

    private fun removeTask(taskId: String) {
        taskList.removeAll { it.id == taskId }
        StorageOperations.writeTaskList(this, taskList)
        Toast.makeText(this, "Task removed!", Toast.LENGTH_LONG).show()

    }
}