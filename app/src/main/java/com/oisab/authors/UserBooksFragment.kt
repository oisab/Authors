package com.oisab.authors

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class UserBooksFragment : Fragment(R.layout.user_books_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountButton: Button = view.findViewById(R.id.accountButton)
        val authorsButton: Button = view.findViewById(R.id.authorsButton)

        accountButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.mainContainerView, UserSettingsFragment())
                ?.commitNow()
        }

        authorsButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.mainContainerView, AuthorsListFragment())
                ?.commitNow()
        }
    }
}