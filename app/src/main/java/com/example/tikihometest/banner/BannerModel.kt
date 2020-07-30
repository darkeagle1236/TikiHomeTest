package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.network.GetDataService
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BannerModel:BannerContract.BannerModel {
    override fun callGetBannerApi(onGetBannerListFinishListener: OnGetBannerListFinishListener) {
        val service = RetrofitClientInstance.client.create(GetDataService::class.java)
        val call: Call<BannerResponse> = service.getBannerList()
        call.enqueue(object : Callback<BannerResponse> {
            override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
                when (response.code()) {
                    200 -> {
                        onGetBannerListFinishListener.onSuccess(response.body()!!)
                    }
                    else -> {
                        onGetBannerListFinishListener.onFailure()
                    }
                }
            }

            override fun onFailure(call: Call<BannerResponse>, t: Throwable) {
                onGetBannerListFinishListener.onFailure()
            }
        })
    }
}