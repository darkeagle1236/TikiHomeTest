package com.example.tikihometest.quicklink

import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import com.example.tikihometest.network.GetDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuickLinkModel:QuickLinkContract.QuickLinkModel {
    override fun getQuickLinkList(onGetQuickLinkListFinishListener: OnGetQuickLinkListFinishListener) {
        val service = RetrofitClientInstance.client.create(GetDataService::class.java)
        val call: Call<QuickLinkResponse> = service.getQuickLinkList()
        call.enqueue(object : Callback<QuickLinkResponse> {
            override fun onResponse(call: Call<QuickLinkResponse>, response: Response<QuickLinkResponse>) {
                when (response.code()) {
                    200 -> {
                        onGetQuickLinkListFinishListener.onSuccess(response.body()!!)
                    }
                    else -> {
                        onGetQuickLinkListFinishListener.onFailure()
                    }
                }
            }

            override fun onFailure(call: Call<QuickLinkResponse>, t: Throwable) {
                onGetQuickLinkListFinishListener.onFailure()
            }
        })
    }
}