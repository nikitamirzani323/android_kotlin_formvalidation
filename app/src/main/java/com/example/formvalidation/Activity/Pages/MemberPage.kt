package com.example.formvalidation.Activity.Pages

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formvalidation.Activity.Pages.ui.theme.FormValidationTheme
import com.example.formvalidation.R

class MemberPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormValidationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MemberPage(
                        this,
                        name = "Member",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MemberPage(activity: Activity, name: String, modifier: Modifier = Modifier) {
    val username = activity.intent.getStringExtra("username")?:""

    Column(
        modifier = Modifier
    ) {
        TopBar(
            onBackClick = {
                activity.finish()
            }
        )
        Text(text = username.toString(), modifier=Modifier.padding(10.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBackClick:()->Unit){
    TopAppBar(title = { Text(text = "Member", color = Color.White)},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Blue,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),

        actions = {
            IconButton(onClick = onBackClick) {
                Icon(painter = painterResource(R.drawable.baseline_logout_24) , contentDescription = null)
            }
        }
    )
}