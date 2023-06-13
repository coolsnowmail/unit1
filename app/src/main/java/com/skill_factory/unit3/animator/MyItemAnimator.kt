package com.skill_factory.unit3.animator

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.skill_factory.unit3.R

class MyItemAnimator(private val context: Context) : DefaultItemAnimator() {
    val animAdd: Animation = AnimationUtils.loadAnimation(context, R.anim.slide_from_right)
    val animRemove: Animation = AnimationUtils.loadAnimation(context, R.anim.slide_to_right)
    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(animAdd)
    }

    override fun getAddDuration(): Long {
        return animAdd.duration
    }

    override fun onRemoveStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(animRemove)
    }

    override fun getRemoveDuration(): Long {
        return animRemove.duration
    }

    //    val animAdd :Animation! = AnimationUtils.loadAnimation(context, )
//    override fun getAddDuration(): Long {
//        return super.getAddDuration()
//    }
//
//    override fun onRemoveStarting(item: RecyclerView.ViewHolder?) {
//        super.onRemoveStarting(item)
//    }
//
//    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
//        super.onAddStarting(item)
//    }
}