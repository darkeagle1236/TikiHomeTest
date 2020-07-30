package com.example.tikihometest.network

import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import retrofit2.Call
import retrofit2.http.*

interface GetDataService {
    @GET("v2/home/banners/v2")
    fun getBannerList(): Call<BannerResponse>
    @GET("shopping/v2/widgets/quick_link")
    fun getQuickLinkList():Call<QuickLinkResponse>
}