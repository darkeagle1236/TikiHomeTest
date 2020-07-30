package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse

class BannerPresenterImpl(var iView:BannerContract.BannerView):BannerContract.BannerPresenter,OnGetBannerListFinishListener {
    var iModel = BannerModel()
    override fun getBanner() {
        iView.showBannerProgress()
        iModel.callGetBannerApi(this)
    }

    override fun onSuccess(response: BannerResponse) {
        iView.showBannerResult(response)
        iView.hideBannerProgress()
    }

    override fun onFailure() {
        iView.hideBannerProgress()
    }
}