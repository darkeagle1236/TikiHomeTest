package com.example.tikihometest.model.flashdeal


data class FlashDealResponse(
    val `data`: List<Data>,
    val tabs: List<Tab>,
    val version: String
)