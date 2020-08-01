package com.example.tikihometest.flashdeal

import com.example.tikihometest.model.flashdeal.Data
import com.example.tikihometest.model.flashdeal.FlashDealResponse
import retrofit2.Response

interface FlashDealContract {
    interface FlashDealView{
        fun showFlashDealProgress()
        fun hideFlashDealProgress()
        fun showFlashDealResult(response: FlashDealResponse)
        fun initFlashDealPresenter()
        fun initFlashDealRcv()
    }
    interface FlashDealPresenter{
        suspend fun getFlashDealList():Response<FlashDealResponse>
    }
    interface FlashDealModel{
        suspend fun callGetFlashDealApi():Response<FlashDealResponse>
    }
}