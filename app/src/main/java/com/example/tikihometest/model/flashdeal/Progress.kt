package com.example.tikihometest.model.flashdeal

data class Progress(
    val percent: Double,
    val qty: Int,
    val qty_ordered: Int,
    val qty_remain: Int,
    val status: String
)