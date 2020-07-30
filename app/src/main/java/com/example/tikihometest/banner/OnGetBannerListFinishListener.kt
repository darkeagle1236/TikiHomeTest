package com.example.tikihometest.banner

import com.example.tikihometest.model.banner.BannerResponse

interface OnGetBannerListFinishListener {
    fun onSuccess(response: BannerResponse)
    fun onFailure()
}