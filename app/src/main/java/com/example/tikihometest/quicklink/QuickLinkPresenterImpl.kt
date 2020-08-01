package com.example.tikihometest.quicklink

import com.example.tikihometest.model.quicklink.Data
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import kotlin.math.max


class QuickLinkPresenterImpl(var iView:QuickLinkContract.QuickLinkView):QuickLinkContract.QuickLinkPresenter {

    var iModel = QuickLinkModel()
    override suspend fun callGetQuickLinkList():List<Data> {
        var unSortedQuickLinkResponse =  iModel.getQuickLinkList().body()!!
        return sortQuickLinkList(unSortedQuickLinkResponse)
    }

    override fun sortQuickLinkList(unSortedQuickLinkResponse: QuickLinkResponse): List<Data> {
        var finalResultList = ArrayList<Data>()
        val size: Int = max(unSortedQuickLinkResponse.data[0].size, unSortedQuickLinkResponse.data[1].size)

        for (i in 0 until size) {
            if (i < unSortedQuickLinkResponse.data[0].size) finalResultList.add(unSortedQuickLinkResponse.data[0][i])
            if (i < unSortedQuickLinkResponse.data[1].size) finalResultList.add(unSortedQuickLinkResponse.data[1][i])
        }
        return finalResultList
    }



}