package com.home.kakaodemo.screen

import android.view.View
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.home.kakaodemo.R
import org.hamcrest.Matcher

open class HomeActivityScreen : Screen<HomeActivityScreen>() {

    val kRecyclerView: KRecyclerView = KRecyclerView(
        { withId(R.id.recycler_view) },
        itemTypeBuilder = {
            itemType(::FirstItem)
            itemType(::SecondItem)
        })

    class FirstItem(parent: Matcher<View>) : KRecyclerItem<FirstItem>(parent) {
        val cardView: KView = KView(parent) { withId(R.id.card_view) }
        val textView: KTextView = KTextView(parent) { withId(R.id.text_view) }
    }

    class SecondItem(parent: Matcher<View>) : KRecyclerItem<SecondItem>(parent) {
        val cardView: KView = KView(parent) { withId(R.id.card_view) }
        val textView: KTextView = KTextView(parent) { withId(R.id.text_view) }
    }
}
