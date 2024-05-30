package com.example.formvalidation

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(context: Context,modifier: Modifier = Modifier){
    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    var passvisibility by remember {
        mutableStateOf(false)
    }
    val iconPass = if (passvisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Form",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = username.value,
            onValueChange = {username.value = it },
            label = {
                Text(text = "Username")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password.value,
            singleLine = true,
            onValueChange = {password.value = it},
            label = {
                Text(text = "Password")
            },
            trailingIcon = {
                           IconButton(onClick = {
                               passvisibility = !passvisibility
                           }) {
                               Icon(painter = iconPass,
                                   contentDescription = null)
                           }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if(passvisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
                if(username.value.isEmpty()){
                    Toast.makeText(context,"Please Enter username",Toast.LENGTH_SHORT).show()
                }else if(password.value.isEmpty()){
                    Toast.makeText(context,"Please Enter password",Toast.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(context, MemberScreenActivity::class.java)
                    context.startActivity(intent)
                }
            }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}