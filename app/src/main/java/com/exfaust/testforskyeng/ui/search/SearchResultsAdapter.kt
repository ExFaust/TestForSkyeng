package com.exfaust.testforskyeng.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exfaust.testforskyeng.R
import com.exfaust.testforskyeng.data.model.Meanings

class SearchResultsAdapter(var items: List<Meanings>, val callback: Callback) : RecyclerView.Adapter<SearchResultsAdapter.SearchResultHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = SearchResultHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_result_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchResultHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class SearchResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView = itemView.findViewById<TextView>(R.id.itemTextView)

        fun bind(item: Meanings) {
            textView.text = item.translation.text

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Meanings)
    }

}