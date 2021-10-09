package com.oisab.authors.screens.main.suggestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.oisab.authors.R

class SuggestedAuthorsAdapter : RecyclerView.Adapter<SuggestedAuthorsAdapter.AuthorsViewHolder>() {
    private val items: ArrayList<CellSuggestedBook> = ArrayList() // array of data

    fun setData(data: List<CellSuggestedBook>) { // change data in recyclerView
        this.items.clear()
        this.items.addAll(data)
        notifyDataSetChanged() // redraw recyclerView with new data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return AuthorsViewHolder(layoutInflater.inflate(R.layout.cell_suggested_books, parent, false))
    }

    override fun onBindViewHolder(holder: AuthorsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AuthorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: AppCompatTextView = itemView.findViewById(R.id.authorTitleView)
        private val iconView: AppCompatImageView = itemView.findViewById(R.id.authorIconView)

        fun bind(suggestedBook: CellSuggestedBook) {
            if (suggestedBook.icon > 0) {
                iconView.setImageResource(suggestedBook.icon)
            }
            textView.text = suggestedBook.name
        }
    }
}