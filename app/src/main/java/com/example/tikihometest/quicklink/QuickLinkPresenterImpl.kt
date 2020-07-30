package com.example.tikihometest.quicklink

import com.example.tikihometest.model.quicklink.Data
import com.example.tikihometest.model.quicklink.QuickLinkResponse


class QuickLinkPresenterImpl(var iView:QuickLinkContract.QuickLinkView):QuickLinkContract.QuickLinkPresenter,OnGetQuickLinkListFinishListener {

    var iModel = QuickLinkModel()
    override fun callGetQuickLinkList() {
        iView.showQuickLinkProgress()
        iModel.getQuickLinkList(this)
    }

    override fun onSuccess(quickLinkResponse: QuickLinkResponse) {
        iView.hideQuickLinkProgress()
        var finalResultList = ArrayList<Data>()
        val size: Int = Math.max(quickLinkResponse.data[0].size, quickLinkResponse.data[1].size)

        for (i in 0 until size) {
            if (i < quickLinkResponse.data[0].size) finalResultList.add(quickLinkResponse.data[0][i])
            if (i < quickLinkResponse.data[1].size) finalResultList.add(quickLinkResponse.data[1][i])
        }
        iView.showQuickLinkResult(finalResultList)
    }

    override fun onFailure() {
        iView.hideQuickLinkProgress()
    }

}