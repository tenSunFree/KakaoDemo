package com.home.kakaodemo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.home.kakaodemo.common.BaseDelegatesAdapter
import com.home.kakaodemo.common.ItemDelegate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.home.kakaodemo.R
import com.home.kakaodemo.model.HomePojo

class HomeRecyclerViewAdapter : BaseDelegatesAdapter<HomeRecyclerViewAdapter.ListItem>(
    FirstItemDelegate(), SecondItemDelegate(), LastItemDelegate()
) {

    companion object {
        val lastItem = ListItem.LastItem
    }

    sealed class ListItem {
        data class FirstItem(val result: HomePojo.Result) : ListItem()
        data class SecondItem(val result: HomePojo.Result) : ListItem()
        object LastItem : ListItem()
    }

    private class FirstItemDelegate : ItemDelegate<ListItem.FirstItem, FirstItemDelegate.Holder> {

        override fun itemType() = ListItem.FirstItem::class.java

        override fun createVewHolder(parent: ViewGroup) =
            Holder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_home_recycler_view_first_item,
                    parent, false
                )
            )

        override fun bindView(position: Int, item: ListItem.FirstItem, holder: Holder) {
            holder.textView.text = item.result.name
            Glide.with(holder.imageView).load(item.result.imageUrl)
                .transform(CenterCrop(), RoundedCorners(16))
                .into(holder.imageView)
            holder.cardView.setOnClickListener {
                Toast.makeText(holder.cardView.context, item.result.name, Toast.LENGTH_SHORT).show()
            }
        }

        class Holder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.text_view)
            val imageView: ImageView = view.findViewById(R.id.image_view)
            val cardView: CardView = view.findViewById(R.id.card_view)
        }
    }

    private class SecondItemDelegate :
        ItemDelegate<ListItem.SecondItem, SecondItemDelegate.Holder> {

        override fun itemType() = ListItem.SecondItem::class.java

        override fun createVewHolder(parent: ViewGroup) =
            Holder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_home_recycler_view_second_item,
                    parent, false
                )
            )

        override fun bindView(position: Int, item: ListItem.SecondItem, holder: Holder) {
            holder.textView.text = item.result.name
            Glide.with(holder.imageView).load(item.result.imageUrl)
                .transform(CenterCrop(), CircleCrop())
                .into(holder.imageView)
            holder.cardView.setOnClickListener {
                Toast.makeText(holder.cardView.context, item.result.name, Toast.LENGTH_SHORT).show()
            }
        }

        class Holder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.text_view)
            val imageView: ImageView = view.findViewById(R.id.image_view)
            val cardView: CardView = view.findViewById(R.id.card_view)
        }
    }

    private class LastItemDelegate : ItemDelegate<ListItem.LastItem, LastItemDelegate.Holder> {

        override fun itemType() = ListItem.LastItem::class.java

        override fun createVewHolder(parent: ViewGroup) =
            Holder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_home_recycler_view_last_item,
                    parent, false
                )
            )

        override fun bindView(position: Int, item: ListItem.LastItem, holder: Holder) {}

        class Holder(view: View) : RecyclerView.ViewHolder(view)
    }
}
