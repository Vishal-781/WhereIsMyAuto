package com.example.whereismyauto.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whereismyauto.R
import com.example.whereismyauto.splashscreen.SplashViewModel
import com.example.whereismyauto.ui.theme.color_primary
import com.example.whereismyauto.ui.theme.color_white
import com.example.whereismyauto.uicommon.AppHeader
import java.io.StringReader

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color_white),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AppHeader(modifier = Modifier.padding(64.dp), titleText = "Need a ride" )
        EmailInputField(
            modifier = Modifier.padding(top = 16.dp),
            viewModel = viewModel
        )
        PasswordInputField(
            modifier = Modifier.padding(top = 16.dp),
            viewModel = viewModel
        )
        LoginButton(
            modifier = Modifier.padding(top = 32.dp),
            handleLogin = {viewModel.handleLogin()}
        )
        SignUpText(modifier = Modifier.padding(16.dp), viewModel = viewModel)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInputField(
    modifier: Modifier,
    viewModel: LoginViewModel
) {
    OutlinedTextField(
        modifier = modifier,
        value = viewModel.email,
        onValueChange = {
            viewModel.updateEmail(it)
                        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(stringResource(id = R.string.email)) }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {
    var showPassword by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier,
        value = viewModel.password,
        onValueChange = {
            viewModel.updatePassword(it)
                        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(stringResource(id = R.string.password)) }, // Corrected here
        trailingIcon = {
            val image = if (showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24
            val description = if (showPassword) stringResource(id = R.string.hide_password) else stringResource(id = R.string.show_password)
            IconButton(onClick = { showPassword = !showPassword }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = description
                )
            }
        }
    )
}

@Composable
fun LoginButton(
    modifier: Modifier,
    handleLogin : () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { handleLogin()},
        content = { Text("Login") },
    )
}

@Composable
fun SignUpText(
    modifier: Modifier,
    viewModel: LoginViewModel
){
    TextButton(
        onClick = { viewModel.goToSignUp() },
        modifier = modifier
    ) {

        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.no_account))
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = color_primary,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append(stringResource(id = R.string.sign_up))
                }

            }
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(viewModel = LoginViewModel())
}

