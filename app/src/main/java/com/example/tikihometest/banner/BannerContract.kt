package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse
import retrofit2.Response

interface BannerContract {
    interface BannerView{
        fun showBannerProgress()
        fun hideBannerProgress()
        fun showBannerResult(response: BannerResponse)
        fun initBannerPresenter()
        fun initBannerRcv()
    }
    interface BannerModel{
        suspend fun callGetBannerApi():Response<BannerResponse>
    }
    interface BannerPresenter{
        suspend fun getBanner():Response<BannerResponse>
    }
}