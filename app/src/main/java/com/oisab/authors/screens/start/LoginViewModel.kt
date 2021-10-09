    package com.oisab.authors.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed class LoginState {
    object DefaultState : LoginState()
    object SendingState : LoginState()
    object LoginSucceededState : LoginState()
    class ErrorState(val message: String): LoginState()
}

class LoginViewModel: ViewModel() {

    val state = MutableLiveData<LoginState>(LoginState.DefaultState)

    fun clickLoginButton(login: String, password: String) {
        state.value = LoginState.SendingState
        if (!validateLogin(login = login)) {
            state.value = LoginState.ErrorState(message = "Login validation failed")
        } else if (!validatePassword(password = password)) {
            state.value = LoginState.ErrorState(message = "Password validation failed")
        } else {
            state.value = LoginState.LoginSucceededState
        }
    }

    private fun validateLogin(login: String): Boolean {
        return login.matches(Regex("^[\\w! #\$%&‘*+-/=?^`~.]{1,64}@[\\w! #\$%&‘*+-/=?^`~.]" +
                "{1,253}\\.[a-z]{2,6}$"))
    }

    private fun validatePassword(password: String): Boolean {
        return password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
                "(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,32}$"))
    }
}