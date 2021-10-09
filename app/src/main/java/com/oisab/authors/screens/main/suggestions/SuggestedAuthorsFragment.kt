package com.oisab.authors.screens.main.suggestions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oisab.authors.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SuggestedAuthorsFragment : Fragment(R.layout.suggested_authors_fragment) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var suggestedAuthorsViewModel: SuggestedAuthorsViewModel
    private val authorsAdapter = SuggestedAuthorsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        suggestedAuthorsViewModel = ViewModelProvider(this, viewModelFactory).get(
            SuggestedAuthorsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authorsView: RecyclerView = view.findViewById(R.id.authorsView)
        authorsView.adapter = authorsAdapter
        authorsView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        suggestedAuthorsViewModel.generateData()
        suggestedAuthorsViewModel.items.observe(viewLifecycleOwner, {
            authorsAdapter.setData(it)
        })
    }
}