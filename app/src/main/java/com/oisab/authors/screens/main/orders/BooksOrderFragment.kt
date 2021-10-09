package com.oisab.authors.screens.main.orders

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.oisab.authors.R

class BooksOrderFragment : Fragment(R.layout.books_order_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buyButton: AppCompatButton = view.findViewById(R.id.buyButton)

        buyButton.setOnClickListener {
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
        }
    }
}