package com.skill_factory.unit3.adapter

import androidx.recyclerview.widget.DiffUtil

class ProductDiff(val oldList: ArrayList<Product>, val newList: ArrayList<Product>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == oldList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old: Product = oldList[oldItemPosition]
        val new: Product = newList[newItemPosition]
        return old.id == new.id && old.name == new.name && old.desc == new.desc
    }

}