package com.kelompok4.core.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelompok4.core.databinding.ItemSmallGameBinding
import com.kelompok4.core.domain.Games
import com.kelompok4.core.utils.backgroundImageContainer

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    private val searchGamesData = ArrayList<Games>()
    var onClickListenerItem: ((Int) -> Unit)? = null

    fun setData(data: List<Games>) {
        searchGamesData.clear()
        searchGamesData.addAll(data)
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(val itemSearchGameBinding: ItemSmallGameBinding) :
        RecyclerView.ViewHolder(itemSearchGameBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder = SearchViewHolder(
        ItemSmallGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        with(holder) {
            with(searchGamesData[position]) {
                val contextHolder = holder.itemView.context
                backgroundImageContainer(
                    contextHolder,
                    null,
                    backgroundImage,
                    itemSearchGameBinding.backgroundImage
                )
                itemSearchGameBinding.txtTitleSearchGame.text = name
                holder.itemView.setOnClickListener {
                    onClickListenerItem?.invoke(id)
                }
            }
        }
    }

    override fun getItemCount(): Int = searchGamesData.size
}