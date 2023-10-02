package com.example.testproject

import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproject.ui.theme.MainGreen
import com.example.testproject.ui.theme.Pink40
import com.example.testproject.ui.theme.TestProjectTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.text.Normalizer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestProjectTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Green),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(MainGreen),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Chat",
                            modifier = Modifier,
                            fontWeight = Bold,
                            fontSize = 20.sp ,
                            color = White
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    UIPreview()
                    BottomAppBar(
                        modifier = Modifier
                            .height(60.dp)
                    ) {
                        UserInput()
                    }
                }
            }
        }
    }
}

data class Message(val author: String, val message: String)

@Composable
fun MessageCard(msg: Message) {
    Column() {
        Text(text = msg.author)
        Text(text = msg.message)
    }
}

@Composable
fun AccountIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInput() {
    var text = remember { mutableStateOf(TextFieldValue("")) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(50.dp)
    ) {
        TextField(
            value = text.value,
            onValueChange = { text.value = it},
            modifier = Modifier
                .background(color = Blue,shape = CircleShape),
            placeholder = { Text(text = "Type here..." )},
        )
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { println("Bruh") },
            modifier = Modifier

        ) { Text(text = "Send", fontSize = 15.sp, maxLines = 1)}
    }
}

@Preview()
@Composable
fun UIPreview() {
    Row(
        modifier = Modifier
            .padding(all = 2.dp)
    ) {
        AccountIcon()
        Spacer(modifier = Modifier.width(5.dp))
        MessageCard(msg = Message("Resh", "Hi"))
    }
}
