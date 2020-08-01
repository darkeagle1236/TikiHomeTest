package com.example.tikihometest.flashdeal

import RetrofitClientInstance
import com.example.tikihometest.model.flashdeal.FlashDealResponse
import com.example.tikihometest.network.GetDataService
import retrofit2.Response

class FlashDealModel():FlashDealContract.FlashDealModel {
    override suspend fun callGetFlashDealApi():Response<FlashDealResponse> {
        val service = RetrofitClientInstance.client.create(GetDataService::class.java)
        return service.getFlashDealList()
    }

}