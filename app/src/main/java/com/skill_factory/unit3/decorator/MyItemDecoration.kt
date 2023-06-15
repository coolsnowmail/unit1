package com.skill_factory.unit3.decorator

import android.annotation.SuppressLint
import android.graphics.Canvas
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.skill_factory.unit3.R
import com.skill_factory.unit3.R.*

class MyItemDecoration:RecyclerView.ItemDecoration() {
    @SuppressLint("ResourceAsColor")
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        parent.children.forEachIndexed { index, view ->
            if (index %2 ==0) {
                view.setBackgroundColor(color.yellow)
            } else {
                view.setBackgroundColor(color.blue)
            }
        }
    }
}