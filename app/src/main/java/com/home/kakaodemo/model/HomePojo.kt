package com.home.kakaodemo.model

data class HomePojo(
    val results: List<Result>
) {
    data class Result(
        val type: Int,
        val imageUrl: String,
        val name: String
    )
}