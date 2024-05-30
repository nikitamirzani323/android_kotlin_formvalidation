package com.example.formvalidation.Activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.formvalidation.ui.theme.FormValidationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormValidationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.i("padding",innerPadding.toString())
                    HomeScreen(this,modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}