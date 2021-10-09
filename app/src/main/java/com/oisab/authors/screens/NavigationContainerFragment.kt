package com.oisab.authors.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oisab.authors.R

class NavigationContainerFragment : Fragment(R.layout.navigation_container_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)

//        makeCurrentFragment(SuggestedAuthorsFragment())
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.suggestions -> findNavController().navigate(R.id.action_navigationContainerFragment2_to_suggestedAuthorsFragment)
                R.id.orders -> findNavController().navigate(R.id.action_navigationContainerFragment2_to_booksOrderFragment)
                R.id.userSettings -> findNavController().navigate(R.id.action_navigationContainerFragment2_to_userSettingsFragment)
                R.id.myBooks -> findNavController().navigate(R.id.action_navigationContainerFragment2_to_myBooksFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.navigationContainerFragment, fragment)
            ?.commit()
    }
}