package com.example.tikihometest.quicklink

import com.example.tikihometest.model.quicklink.Data

interface QuickLinkContract {
    interface QuickLinkView{
        fun showQuickLinkProgress()
        fun hideQuickLinkProgress()
        fun showQuickLinkResult(dataList: List<Data>)
        fun initQuickLinkPresenter()
        fun initQuickLinkRcv()
    }
    interface QuickLinkPresenter{
        fun callGetQuickLinkList()
    }
    interface QuickLinkModel{
        fun getQuickLinkList(onGetQuickLinkListFinishListener: OnGetQuickLinkListFinishListener)
    }
}