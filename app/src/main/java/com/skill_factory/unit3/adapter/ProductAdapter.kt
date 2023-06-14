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
import com.skill_factory.unit3.databinding.ItemBinding

class ProductAdapter(var data: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(val itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
//        val icon = itemView.i
//        val textName = itemView.findViewById<TextView>(R.id.text_name)
//        val textDesc = itemView.findViewById<TextView>(R.id.text_desc)
        @SuppressLint("ResourceType")
        fun bindingItem(product: Product) {
            itemBinding.icon.setImageResource(product.idIcon)
            itemBinding.textName.text = product.name
            itemBinding.textDesc.text = product.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = data[position]
        holder.bindingItem(product)
//        holder.icon.setImageResource(data[position].idIcon)
//        holder.textName.text = data[position].name
//        holder.textDesc.text = data[position].desc
    }

    override fun getItemCount(): Int {
        return data.size
    }

}