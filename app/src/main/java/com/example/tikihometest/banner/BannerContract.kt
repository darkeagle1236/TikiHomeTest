package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse

interface BannerContract {
    interface BannerView{
        fun showProgress()
        fun hideProgress()
        fun showResults(response: BannerResponse)
        fun initPresenter()
    }
    interface BannerModel{
        fun callGetBannerApi(onGetBannerListFinishListener: OnGetBannerListFinishListener)
    }
    interface BannerPresenter{
        fun getBanner()
    }
}