package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse
import retrofit2.Response

class BannerPresenterImpl(var iView:BannerContract.BannerView):BannerContract.BannerPresenter,OnGetBannerListFinishListener {
    var iModel = BannerModel()
    override suspend fun getBanner():Response<BannerResponse> {
        iView.showBannerProgress()
        return iModel.callGetBannerApi()
    }

    override fun onSuccess(response: BannerResponse) {
        iView.showBannerResult(response)
        iView.hideBannerProgress()
    }

    override fun onFailure() {
        iView.hideBannerProgress()
    }
}