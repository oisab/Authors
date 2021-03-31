package com.oisab.authors

import android.content.SharedPreferences
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed class SettingsState {
    object DefaultState: SettingsState()
    object InChangingProcess : SettingsState()
    object SaveSucceededState : SettingsState()
    object ErrorState: SettingsState()
}

class UserSettingsViewModel: ViewModel() {
    val state = MutableLiveData<SettingsState>(SettingsState.DefaultState)

fun saveUserData(sharedPref: SharedPreferences, lastNameKey: String, lastNameValue: AppCompatEditText,
                 firstNameKey: String, firstNameValue: AppCompatEditText) {
        state.value = SettingsState.InChangingProcess
        saveStringData(sharedPref, lastNameKey, lastNameValue.text.toString())
        saveStringData(sharedPref, firstNameKey, firstNameValue.text.toString())
        Thread.sleep(2_000)
        state.value = SettingsState.SaveSucceededState
    }

    private fun saveStringData(sharedPref: SharedPreferences, key: String, value: String) {
        sharedPref.edit()
            .putString(key, value)
            .apply()
    }

    fun setEditTextValue(sharedPref: SharedPreferences, lastNameKey: String, lastNameValue: AppCompatEditText,
                         firstNameKey: String, firstNameValue: AppCompatEditText) {
        lastNameValue.setText(sharedPref.getString(lastNameKey, ""))
        firstNameValue.setText(sharedPref.getString(firstNameKey, ""))
    }
}