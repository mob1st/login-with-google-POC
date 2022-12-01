package com.example.login_poc.features.login

import android.annotation.SuppressLint
import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login_poc.featureLogin.R
import com.example.login_poc.ui.theme.Sun202
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginScreen(
    auth: FirebaseAuth,
    navController: NavController
) {
    val focusManager = LocalFocusManager.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isPasswordValid by derivedStateOf {
        password.length > 7
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .scrollable(state = scrollState, orientation = Orientation.Vertical),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.orayo),
            contentDescription = "Sun",
            modifier = Modifier.padding(top = 35.dp)
        )
        Text(
            text = "Sunny",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Sun202,
            modifier = Modifier.padding(top = 16.dp)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            trailingIcon = {
                if (email.isNotBlank()) {
                    IconButton(onClick = {
                        email = ""
                    }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear email")
                    }
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
            isError = !isEmailValid
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = ""
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
            isError = !isPasswordValid,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )

        Button(
            modifier = Modifier
                .padding()
                .padding(vertical = 14.dp),
            colors = ButtonDefaults.buttonColors(Sun202),
            onClick = {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Log.i("LoginStatus", "Success")
                            navController.navigate("home")
                        } else {
                            Log.i("LoginStatus", "Failed")
                            //Show message "Email ou senha invalidos"
                        }
                    }
            }
        ) {
            Box(
                modifier = Modifier
                    .background(Sun202)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Login", color = Color.White, fontSize = 20.sp)
            }
        }

        Row() {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.google_icon),
                contentDescription = "Google it",
                modifier = Modifier
                    .padding(top = 35.dp)
                    .padding(end = 15.dp)
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.facebook_icon),
                contentDescription = "Facebook",
                modifier = Modifier
                    .padding(top = 35.dp)
                    .padding(start = 15.dp)
            )
        }
    }
}