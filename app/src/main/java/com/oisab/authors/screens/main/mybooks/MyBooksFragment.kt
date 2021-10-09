package com.oisab.authors.screens.main.mybooks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oisab.authors.R

class MyBooksFragment : Fragment(R.layout.my_books_fragment) {
    private val myBooksAdapter = MyBooksAdapter()
    private val myBooksViewModel = MyBooksViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myBooksView: RecyclerView = view.findViewById(R.id.myBooksView)
        myBooksView.adapter = myBooksAdapter
        myBooksView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        myBooksViewModel.generateData()
        myBooksViewModel.items.observe(viewLifecycleOwner) {
            myBooksAdapter.setData(it)
        }
    }

}