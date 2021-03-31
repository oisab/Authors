package com.oisab.authors

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

class UserSettingsFragment : Fragment(R.layout.user_settings) {
    private var LAST_NAME = "last_name"
    private var FIRST_NAME = "first_name"
    private val userSettingsViewModel = UserSettingsViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userSharedPref = activity!!.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE)
        val userLastName: AppCompatEditText = view.findViewById(R.id.userLastName) // create EditTexts
        val userFirstName: AppCompatEditText = view.findViewById(R.id.userFirstName)
        val saveUserDataButton: AppCompatButton = view.findViewById(R.id.savetUserDataButton)

        saveUserDataButton.setOnClickListener{
            userSettingsViewModel.saveUserData(userSharedPref, LAST_NAME, userLastName, FIRST_NAME, userFirstName)
        }
        userSettingsViewModel.setEditTextValue(userSharedPref, LAST_NAME, userLastName, FIRST_NAME, userFirstName)
        observeSaveButton()
    }

    private fun observeSaveButton() {
        userSettingsViewModel.state.observe(viewLifecycleOwner, Observer<SettingsState> { state ->
            when (state) {
                is SettingsState.DefaultState -> {
                    showToast("DefaultState")
                }
                is SettingsState.InChangingProcess -> {
                    showToast("In changing process")
                }
                is SettingsState.SaveSucceededState -> {
                    showToast("Saved")
                }
                is SettingsState.ErrorState -> {
                    showToast("Error in the saving process")
                }
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}