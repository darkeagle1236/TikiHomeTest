package com.example.tikihometest.quicklink

import RetrofitClientInstance
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import com.example.tikihometest.network.GetDataService
import retrofit2.Response

class QuickLinkModel:QuickLinkContract.QuickLinkModel {
    override suspend fun getQuickLinkList():Response<QuickLinkResponse> {
        val service = RetrofitClientInstance.client.create(GetDataService::class.java)
        return service.getQuickLinkList()
    }
}