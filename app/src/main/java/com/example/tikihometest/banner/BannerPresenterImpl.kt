package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse
import retrofit2.Response

class BannerPresenterImpl(var iView:BannerContract.BannerView):BannerContract.BannerPresenter {
    var iModel = BannerModel()
    override suspend fun getBanner():Response<BannerResponse> {
        iView.showBannerProgress()
        return iModel.callGetBannerApi()
    }
}