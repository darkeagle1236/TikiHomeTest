package com.example.tikihometest.quicklink

import com.example.tikihometest.model.quicklink.Data
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import retrofit2.Response

interface QuickLinkContract {
    interface QuickLinkView{
        fun showQuickLinkProgress()
        fun hideQuickLinkProgress()
        fun showQuickLinkResult(dataList: List<Data>)
        fun initQuickLinkPresenter()
        fun initQuickLinkRcv()
    }
    interface QuickLinkPresenter{
        suspend fun callGetQuickLinkList():List<Data>
        fun sortQuickLinkList(unSortedQuickLinkResponse: QuickLinkResponse):List<Data>
    }
    interface QuickLinkModel{
        suspend fun getQuickLinkList():Response<QuickLinkResponse>
    }
}