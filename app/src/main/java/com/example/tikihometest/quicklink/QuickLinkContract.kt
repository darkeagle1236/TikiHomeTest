package com.example.tikihometest.quicklink

import com.example.tikihometest.banner.OnGetBannerListFinishListener
import com.example.tikihometest.model.quicklink.QuickLinkResponse

interface QuickLinkContract {
    interface QuickLinkView{
        fun showProgress()
        fun hideProgress()
        fun showResults(response: QuickLinkResponse)
        fun initQuickLinkPresenter()
    }
    interface QuickLinkPresenter{
        fun callGetQuickLinkList(onGetBannerListFinishListener: OnGetBannerListFinishListener)
    }
    interface QuickLinkModel{
        fun getQuickLinkList()
    }
}