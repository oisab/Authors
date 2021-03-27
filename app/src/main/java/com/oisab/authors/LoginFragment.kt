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
            if (viewModel.clickLoginButton(login = loginText.text.toString(), password = passwordText.text.toString()))
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.mainContainerView, AuthorsListFragment())
                    ?.commitNow()
        }
        viewModel.state.observe(viewLifecycleOwner, Observer <LoginState> {
            state ->
            when (state) {
                is LoginState.DefaultState ->
                    Toast.makeText(requireContext(), "Default state", Toast.LENGTH_SHORT).show()
                is LoginState.SendingState ->
                    Toast.makeText(requireContext(), "Sending login", Toast.LENGTH_SHORT).show()
                is LoginState.LoginSucceededState ->
                    Toast.makeText(requireContext(), "Success login", Toast.LENGTH_SHORT).show()
                is LoginState.ErrorState ->
                    Toast.makeText(requireContext(), "Error login", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}