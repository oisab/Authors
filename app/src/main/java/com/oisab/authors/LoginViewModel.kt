package com.oisab.authors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed class LoginState {
    object DefaultState : LoginState()
    object SendingState : LoginState()
    object LoginSucceededState : LoginState()
    class ErrorState(val message: String): LoginState()
}

class LoginViewModel: ViewModel() {

    val state = MutableLiveData<LoginState>()

    fun clickLoginButton(login: String, password: String): Boolean {
        state.apply { LoginState.SendingState }
        return if (!validateLogin(login = login)) {
            state.apply { LoginState.ErrorState(message = "Login validation failed") }
            false
        } else if (!validatePassword(password = password)) {
            state.apply { LoginState.ErrorState(message = "Password validation failed") }
            false
        } else {
            state.apply { LoginState.LoginSucceededState }
            true
        }
    }

    private fun validateLogin(login: String): Boolean {
        return login.contains('@') && login.contains('.')
    }

    private fun validatePassword(password: String): Boolean {
        return password.length > 6
    }
}