package com.example.tikihometest.model.hotdeals

data class HotDealsResponse(
    val `data`: List<Data>,
    val tabs: List<Tab>,
    val version: String
)