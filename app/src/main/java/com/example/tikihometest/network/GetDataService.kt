package com.example.tikihometest.network

import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.model.flashdeal.FlashDealResponse
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetDataService {
    @GET("v2/home/banners/v2")
    suspend fun getBannerList(): Response<BannerResponse>
    @GET("shopping/v2/widgets/quick_link")
    suspend fun getQuickLinkList():Response<QuickLinkResponse>
    @GET("v2/widget/deals/hot")
    suspend fun getFlashDealList():Response<FlashDealResponse>

}