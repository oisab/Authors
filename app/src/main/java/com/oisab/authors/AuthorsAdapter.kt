package com.oisab.authors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class AuthorsAdapter: RecyclerView.Adapter<AuthorsAdapter.AuthorsViewHolder>() {
    private val items: MutableList<CellModel> = ArrayList() // array of data

    fun setData(data: List<CellModel>){ // change data in recyclerView
        this.items.clear()
        this.items.addAll(data)
        notifyDataSetChanged() // redraw recyclerView with new data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return AuthorsViewHolder(layoutInflater.inflate(R.layout.cell_test, parent, false))
    }

    override fun onBindViewHolder(holder: AuthorsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AuthorsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: AppCompatTextView = itemView.findViewById(R.id.authorTitleView)
        private val iconView: AppCompatImageView = itemView.findViewById(R.id.authorIconView)

        fun bind(model: CellModel) {
            if (model.icon > 0){
                iconView.setImageResource(model.icon)
            }

            textView.text = model.name
        }
    }
}