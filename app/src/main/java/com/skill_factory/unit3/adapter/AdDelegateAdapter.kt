package com.skill_factory.unit3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.skill_factory.unit3.databinding.ItemAdBinding

class AdDelegateAdapter :
    AbsListItemAdapterDelegate<Ad, Item, AdDelegateAdapter.ItemAdViewHolder>() {

    inner class ItemAdViewHolder(val itemAdBinding: ItemAdBinding) :
        RecyclerView.ViewHolder(itemAdBinding.root) {
        fun bindingItem(product: Ad) {
            itemAdBinding.title.text = product.title
            itemAdBinding.content.text = product.content
        }
    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Ad
    }

    override fun onCreateViewHolder(parent: ViewGroup): ItemAdViewHolder {
        return ItemAdViewHolder(
            ItemAdBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: Ad, holder: ItemAdViewHolder, payloads: MutableList<Any>) {
        holder.bindingItem(item)
    }


}