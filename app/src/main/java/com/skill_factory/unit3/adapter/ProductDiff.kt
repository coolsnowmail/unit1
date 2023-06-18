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
        val old: Item = oldList[oldItemPosition]
        val new: Item = newList[newItemPosition]
////        val product = old as? Product
////        product?.id
//        (old as? Product)?.id
        return if (old is Product && new is Product) {
            old.id == new.id
        } else if (old is Ad && new is Ad) {
            old.id == new.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old: Item = oldList[oldItemPosition]
        val new: Item = newList[newItemPosition]
        return if (old is Product && new is Product) {
            old.id == new.id && old.name == new.name && old.desc == new.desc
        } else if (old is Ad && new is Ad) {
            old.id == new.id && old.content == new.content && old.title == new.title
        } else {
            false
        }
    }
}