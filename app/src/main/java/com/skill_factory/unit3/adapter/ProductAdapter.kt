package com.skill_factory.unit3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.skill_factory.unit3.R
import com.skill_factory.unit3.databinding.ItemAdBinding
import com.skill_factory.unit3.databinding.ItemBinding
import java.io.Serializable
import kotlin.IllegalArgumentException

const val ITEM_VIEW_TYPE_PRODUCT = 0
const val ITEM_VIEW_TYPE_AD = 1

class ProductAdapter(var data: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(val itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindingItem(product: Product) {
            itemBinding.icon.setImageResource(product.idIcon)
            itemBinding.textName.text = product.name
            itemBinding.textDesc.text = product.desc
        }


    }

    inner class ItemAdViewHolder(val itemAdBinding: ItemAdBinding) :
        RecyclerView.ViewHolder(itemAdBinding.root) {
        fun bindingItem(product: Ad) {
            itemAdBinding.title.text = product.title
            itemAdBinding.content.text = product.content
        }
    }


    override fun getItemViewType(position: Int): Int {

        return when(data[position]) {
            is Product -> ITEM_VIEW_TYPE_PRODUCT
            is Ad -> ITEM_VIEW_TYPE_AD
            else -> throw IllegalArgumentException("Invalid item")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_PRODUCT -> ItemViewHolder(
                ItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ITEM_VIEW_TYPE_AD -> ItemAdViewHolder(
                ItemAdBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = data[position]
        when (holder) {
            is ItemAdViewHolder -> holder.bindingItem(product as Ad)
            is ItemViewHolder -> holder.bindingItem(product as Product)
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }



}