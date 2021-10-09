package com.oisab.authors.screens.main.mybooks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.oisab.authors.R

class MyBooksAdapter : RecyclerView.Adapter<MyBooksAdapter.MyBooksViewHolder>() {
    private val myBooks: MutableList<CellMyBook> = ArrayList()

    fun setData(items: MutableList<CellMyBook>) {
        this.myBooks.clear()
        this.myBooks.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBooksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyBooksViewHolder(layoutInflater.inflate(R.layout.cell_my_book, parent, false))
    }

    override fun onBindViewHolder(holder: MyBooksViewHolder, position: Int) {
        holder.bind(myBooks[position])
    }

    override fun getItemCount(): Int {
        return myBooks.size
    }

    class MyBooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val bookNameView: AppCompatTextView = view.findViewById(R.id.myBookNameView)
        private val authorNameView: AppCompatTextView = view.findViewById(R.id.myBookAuthorView)
        private val iconView: AppCompatImageView = view.findViewById(R.id.myBookImageView)

        fun bind(myBook: CellMyBook) {
            if(myBook.icon > 0) {
                iconView.setImageResource(myBook.icon)
            }
            bookNameView.text = myBook.bookName
            authorNameView.text = myBook.authorName
        }
    }
}