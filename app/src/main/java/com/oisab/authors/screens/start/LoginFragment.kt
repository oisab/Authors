package com.oisab.authors.screens.start

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.oisab.authors.R

class LoginFragment : Fragment(R.layout.login_fragment) {

    private var loginViewModel = LoginViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val loginButton: AppCompatButton = view.findViewById(R.id.loginButton)
//        val loginText: AppCompatEditText = view.findViewById(R.id.loginTextField)
//        val passwordText: AppCompatEditText = view.findViewById(R.id.passwordTextField)

        loginButton.setOnClickListener {
//            loginViewModel.clickLoginButton(login = loginText.text.toString(), password = passwordText.text.toString())
            loginViewModel.clickLoginButton(login = "osmanisaev190501@mail.ru", password = "qdiFytF78r^$%64")

        }
        observeLoginState()
    }

    private fun observeLoginState() {
        loginViewModel.state.observe(viewLifecycleOwner, Observer<LoginState> { state ->
            when (state) {
                is LoginState.DefaultState -> {
                    showToast("Default state")
                }
                is LoginState.SendingState -> {
                    showToast("Sending login")
                }
                is LoginState.LoginSucceededState -> {
                    showToast("Successful authorization")
                    findNavController().navigate(R.id.action_loginFragment_to_navigationContainerFragment2)
                }
                is LoginState.ErrorState -> {
                    showToast("Login or password error")
                }
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}