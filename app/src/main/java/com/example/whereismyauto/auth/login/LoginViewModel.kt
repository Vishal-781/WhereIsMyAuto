package com.example.whereismyauto.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private  set

    fun updateEmail(newEmail: String){
        email = newEmail
    }
    fun updatePassword(newPassword: String){
        password = newPassword
    }

    fun handleLogin(){
        // handle login
    }

    fun goToSignUp(){
        // navigate to sign up screen
    }

}