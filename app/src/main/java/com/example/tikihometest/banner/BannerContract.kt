package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse

interface BannerContract {
    interface BannerView{
        fun showBannerProgress()
        fun hideBannerProgress()
        fun showBannerResult(response: BannerResponse)
        fun initBannerPresenter()
        fun initBannerRcv()
    }
    interface BannerModel{
        fun callGetBannerApi(onGetBannerListFinishListener: OnGetBannerListFinishListener)
    }
    interface BannerPresenter{
        fun getBanner()
    }
}