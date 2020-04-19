package com.home.kakaodemo.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ItemDelegate<I, H : RecyclerView.ViewHolder> {

    fun itemType(): Class<out I>

    fun createVewHolder(parent: ViewGroup): H

    fun bindView(position: Int, item: I, holder: H)
}
