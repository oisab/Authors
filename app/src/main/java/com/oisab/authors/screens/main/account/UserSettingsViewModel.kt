package com.oisab.authors.screens.main.account

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserSettingsViewModel : ViewModel() {

    val userLastName = MutableLiveData<String>()
    val userFirstName = MutableLiveData<String>()
    val userPhoneNumber = MutableLiveData<String>()
    val userEmail = MutableLiveData<String>()

    fun saveUserData(
        sharedPref: SharedPreferences,
        lastNameValue: String,
        firstNameValue: String,
        userPhoneNumber: String,
        userEmailValue: String
    ) {
        saveStringData(sharedPref, UserSettingsFragment.LAST_NAME, lastNameValue)
        saveStringData(sharedPref, UserSettingsFragment.FIRST_NAME, firstNameValue)
        saveStringData(sharedPref, UserSettingsFragment.PHONE_NUMBER, userPhoneNumber)
        saveStringData(sharedPref, UserSettingsFragment.EMAIL, userEmailValue)
    }

    fun checkUserData(sharedPref: SharedPreferences) {
        val firstNameValue = sharedPref.getString(UserSettingsFragment.FIRST_NAME, "")
        val lastNameValue = sharedPref.getString(UserSettingsFragment.LAST_NAME, "")
        val phoneValue = sharedPref.getString(UserSettingsFragment.PHONE_NUMBER, "")
        val emailValue = sharedPref.getString(UserSettingsFragment.EMAIL, "")
        userEmail.postValue(emailValue)
        userLastName.postValue(lastNameValue)
        userPhoneNumber.postValue(phoneValue)
        userFirstName.postValue(firstNameValue)
    }

    private fun saveStringData(sharedPref: SharedPreferences, key: String, value: String) {
        sharedPref.edit()
            .putString(key, value)
            .apply()
    }
}