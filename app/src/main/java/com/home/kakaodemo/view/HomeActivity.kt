package com.home.kakaodemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.home.kakaodemo.R
import com.home.kakaodemo.model.HomePojo
import com.home.kakaodemo.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var presenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val homePojo = Gson().fromJson(
            presenter.getJson(), HomePojo::class.java
        )
        val firstItem = 1
        val listItem = homePojo.results.map {
            if (it.type == firstItem) {
                HomeRecyclerViewAdapter.ListItem.FirstItem(it)
            } else {
                HomeRecyclerViewAdapter.ListItem.SecondItem(it)
            }
        }
        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context).apply {
                LinearLayoutManager.VERTICAL
            }
            adapter = HomeRecyclerViewAdapter().apply {
                items = listItem + HomeRecyclerViewAdapter.lastItem
            }
        }
    }
}
