package com.home.kakaodemo.presenter

import com.home.kakaodemo.model.HomeModel

class HomePresenter {

    var model = HomeModel()

    fun getJson(): String {
        return model.json
    }
}