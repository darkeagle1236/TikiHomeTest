package com.example.tikihometest.banner

import RetrofitClientInstance
import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.network.GetDataService
import retrofit2.Response

class BannerModel:BannerContract.BannerModel {
    override suspend fun callGetBannerApi():Response<BannerResponse> {
        val service = RetrofitClientInstance.client.create(GetDataService::class.java)
        return service.getBannerList()
    }
}