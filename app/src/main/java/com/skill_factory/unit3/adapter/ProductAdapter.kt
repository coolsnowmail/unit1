package com.skill_factory.unit3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.skill_factory.unit3.R
import com.skill_factory.unit3.databinding.ItemAdBinding
import com.skill_factory.unit3.databinding.ItemBinding
import java.io.Serializable
import kotlin.IllegalArgumentException

//const val ITEM_VIEW_TYPE_PRODUCT = 0
//const val ITEM_VIEW_TYPE_AD = 1

//var data: ArrayList<Item>
class ProductAdapter() :
    ListDelegationAdapter<List<Item>>() {

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }

    override fun setItems(items: List<Item>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }
}