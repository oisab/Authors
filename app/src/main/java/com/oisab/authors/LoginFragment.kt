package com.oisab.authors

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LoginFragment : Fragment(R.layout.login_fragment) {

    private var viewModel = LoginViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val loginButton: AppCompatButton = view.findViewById(R.id.loginButton)
        val loginText: AppCompatEditText = view.findViewById(R.id.loginTextField)
        val passwordText: AppCompatEditText = view.findViewById(R.id.passwordTextField)

        loginButton.setOnClickListener {
            viewModel.clickLoginButton(login = loginText.text.toString(), password = passwordText.text.toString())
        }
        observeLoginState()
    }

    private fun observeLoginState() {
        viewModel.state.observe(viewLifecycleOwner, Observer<LoginState> { state ->
            when (state) {
                is LoginState.DefaultState -> {
                    showToast("Default state")
                }
                is LoginState.SendingState -> {
                    showToast("Sending login")
                }
                is LoginState.LoginSucceededState -> {
                    showToast("Successful authorization")
                    Thread.sleep(2_000)
                    logInAccount()
                }
                is LoginState.ErrorState -> {
                    showToast("Login or password error")
                }
            }
        })
    }

    private fun logInAccount() {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.mainContainerView, UserBooksFragment())
            ?.commitNow()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}