package com.skill_factory.unit3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.skill_factory.unit3.R

class ProductAdapter(val data: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: ViewBinding) : RecyclerView.ViewHolder(itemView.root) {
//        val icon = itemView.i
//        val textName = itemView.findViewById<TextView>(R.id.text_name)
//        val textDesc = itemView.findViewById<TextView>(R.id.text_desc)

        fun bindingItem(product: Product) {

            itemView.text_

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.icon.setImageResource(data[position].idIcon)
        holder.textName.text = data[position].name
        holder.textDesc.text = data[position].desc
    }

    override fun getItemCount(): Int {
        return data.size
    }

}