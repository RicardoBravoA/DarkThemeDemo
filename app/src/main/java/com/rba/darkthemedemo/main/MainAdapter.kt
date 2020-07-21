package com.rba.darkthemedemo.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rba.darkthemedemo.R
import com.rba.darkthemedemo.model.MenuModel
import com.rba.darkthemedemo.util.diffUtil
import com.rba.darkthemedemo.util.inflate
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(private val onClickMain: (MenuModel) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var list: List<MenuModel> by diffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.icon == new.icon }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(parent.inflate(R.layout.item_main, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClickMain(item) }
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(menuModel: MenuModel) {
            itemView.iconImageView.setImageResource(menuModel.icon)
            itemView.descriptionTextView.text = menuModel.description
        }
    }
}