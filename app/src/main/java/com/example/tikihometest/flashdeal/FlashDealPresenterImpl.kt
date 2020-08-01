package com.example.tikihometest.flashdeal

import com.example.tikihometest.model.flashdeal.Data
import com.example.tikihometest.model.flashdeal.FlashDealResponse
import retrofit2.Response

class FlashDealPresenterImpl(var iView:FlashDealContract.FlashDealView):FlashDealContract.FlashDealPresenter {
    var iModel = FlashDealModel()
    override suspend fun getFlashDealList():Response<FlashDealResponse> {
        return iModel.callGetFlashDealApi()
    }
}