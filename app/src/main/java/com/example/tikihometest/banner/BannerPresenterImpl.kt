package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse

class BannerPresenterImpl(var iView:BannerContract.BannerView):BannerContract.BannerPresenter,OnGetBannerListFinishListener {
    var iModel = BannerModel()
    override fun getBanner() {
        iView.showProgress()
        iModel.callGetBannerApi(this)
    }

    override fun onSuccess(response: BannerResponse) {
        iView.showResults(response)
        iView.hideProgress()
    }

    override fun onFailure() {
        iView.hideProgress()
    }
}