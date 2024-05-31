package m.l.wsb_mobile_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import m.l.wsb_mobile_app.ui.theme.Wsb_mobile_appTheme

class UpdateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val taskId = intent.getStringExtra("task_id")

            Text(text = "$taskId")
        }
    }
}

//@Composable
//fun UpdateView(){
//    val context = LocalContext.current
//    val task_id = intent.getStringExtra("task_id")
//
//    Text(text = "$task_id")
//}
