 package com.oisab.authors.screens.main.account

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.oisab.authors.R

 class UserSettingsFragment : Fragment(R.layout.user_settings_fragment) {
    private val userSettingsViewModel = UserSettingsViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userSharedPref = requireActivity().getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE)
        val lastNameEditText: AppCompatEditText =
            view.findViewById(R.id.userLastName) // get EditTexts View
        val firstNameEditText: AppCompatEditText = view.findViewById(R.id.userFirstName)
        val userEmailEditText: AppCompatEditText = view.findViewById(R.id.userEmail)
        val userPhoneNumber: AppCompatEditText = view.findViewById(R.id.userPhoneNumber)
        val saveUserDataButton: AppCompatButton = view.findViewById(R.id.saveUserDataButton)

        saveUserDataButton.setOnClickListener {
            userSettingsViewModel.saveUserData(
                userSharedPref,
                lastNameEditText.text.toString(),
                firstNameEditText.text.toString(),
                userPhoneNumber.text.toString(),
                userEmailEditText.text.toString()
            )
        }
        userSettingsViewModel.checkUserData(userSharedPref)
        userSettingsViewModel.userFirstName.observe(viewLifecycleOwner, Observer<String> {
            firstNameEditText.setText(it)
        })
        userSettingsViewModel.userLastName.observe(viewLifecycleOwner, Observer<String> {
            lastNameEditText.setText(it)
        })
        userSettingsViewModel.userEmail.observe(viewLifecycleOwner, Observer<String> {
            userEmailEditText.setText(it)
        })
        userSettingsViewModel.userPhoneNumber.observe(viewLifecycleOwner, Observer<String> {
            userPhoneNumber.setText(it)
        })
    }

    companion object {
        const val LAST_NAME = "last_name"
        const val FIRST_NAME = "first_name"
        const val PHONE_NUMBER = "phone_number"
        const val EMAIL = "email"
    }
}