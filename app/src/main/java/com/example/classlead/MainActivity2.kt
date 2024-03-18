package com.example.classlead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.classlead.ui.theme.ClassLeadTheme

class SecondaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassLeadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserInputDisplay()
                }
            }
        }
    }
}

@Composable
fun UserInputDisplay(text: String = "") {
    var currentText by remember { mutableStateOf(text) } // Track user input

    Column {
        Text(text = "Enter your text:")
        OutlinedTextField(
            value = currentText, // Use the currentText state variable
            onValueChange = { newValue ->
                currentText = newValue // Update currentText on user input
            },
            label = { Text("Input") }
        )
        Button(onClick = { /* Handle submit button click here */ }) {
            Text("Submit")
        }
        Text(text = "Your input:")
        Text(text = currentText) // Display the updated currentText
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ClassLeadTheme {
        UserInputDisplay()
    }
}
