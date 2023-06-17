package com.skill_factory.unit3.adapter

import androidx.recyclerview.widget.DiffUtil

class ProductDiff(val oldList: ArrayList<Item>, val newList: ArrayList<Item>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return false
//        if (oldList[oldItemPosition] is Product && newList[newItemPosition] is Product) {
//            return oldList[oldItemPosition].id == newList[newItemPosition].id
//        } else if (oldList[oldItemPosition] is Ad && newList[newItemPosition] is Ad) {
//            return oldList[oldItemPosition].id == newList[newItemPosition].id
//        } else {
//            return false
//        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
//        val old: Item = oldList[oldItemPosition]
//        val new: Item = newList[newItemPosition]
//        return old.id == new.id && old.name == new.name && old.desc == new.desc
    }

}