package m.l.wsb_mobile_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import m.l.wsb_mobile_app.ui.theme.Wsb_mobile_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MyHomeActivityView()
//            startActivity(Intent(LocalContext.current, HomeActivity::class.java))
        }
    }

    @Composable
    fun MyHomeActivityView(){
        val context: Context = LocalContext.current
        val intent: Intent = Intent(context, HomeActivity::class.java)

        intent.putExtra("value", "Lorem Ipsum")

        Button(onClick = { startActivity(intent) }) {
            Text(text = "Go Home")
        }
    }

    @Composable
    fun MyTextField() {
        var text by remember {
            mutableStateOf("")
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Label") },
            placeholder = { Text(text = "Placeholder")},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            trailingIcon = { Icon(imageVector = Icons.Default.Warning, contentDescription = "")},
            isError = true
        )
    }

    var counter: Int = 0

    @Composable
    fun MyButton() {
        var countState: MutableState<Int> = remember {
            mutableIntStateOf(0)
        }
        Column() {
            Button(onClick = { countState.value++ }) {
                Text(text = "Click countState ${countState.value}")
            }
        }
    }

    @Composable
    fun MyExercise2() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Hello!",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Thin,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
            )
            Divider()
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Divider()
            Text(
                text = "Bye!",
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun MyProgress() {
        Column(modifier = Modifier.padding(10.dp)) {
            CircularProgressIndicator(color = Color.Green)
            CircularProgressIndicator(color = Color.Blue, progress = 0.8f)
            LinearProgressIndicator()
            LinearProgressIndicator(
                color = Color.Red,
                progress = 0.5f,
                modifier = Modifier.fillMaxWidth()
            )
            LinearProgressIndicator(
                color = Color.Green,
                modifier = Modifier.fillMaxWidth(),
                trackColor = Color.Red
            )
        }
    }

    @Composable
    fun MyIcon() {
        Column {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
            Divider()
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "", tint = Color.Red)
            Spacer(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxSize()
                    .background(Color.Green)
            )
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .background(Color.Green, CircleShape)
                    .border(2.dp, color = Color.Black, CircleShape)
                    .padding(5.dp)
            )


        }
    }

    @Composable
    fun MyModifier() {
        Column(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxSize()
//                .size(height = 100.dp, width = 100.dp)
                .padding(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Lorem Ipsum Dolore est coś tam coś tam!",
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.White, CircleShape)
                    .clip(CircleShape)
                    .padding(10.dp)
                    .border(2.dp, Color.Blue),
            )
            Text(text = "Test", modifier = Modifier.background(Color.Red))
        }
    }

    @Composable
    fun MyColumnExercise() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hello World!")
            Text(text = "Hello World!")
            Text(text = "Hello World!")
        }
    }

    @Composable
    fun MyRow() {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Hello World!")
            Text(text = "Hello World!")
            Text(text = "Hello World!")
        }
    }

    @Composable
    fun MyColumn() {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Hello World!")
            Text(text = "Hello World!")
            Text(text = "Hello World!")
        }
    }


    @Composable
    fun MyElement() {
        Text(text = "Hello World!")
        Text(text = "Hello World!")
        Text(text = "Hello World!")
    }
}