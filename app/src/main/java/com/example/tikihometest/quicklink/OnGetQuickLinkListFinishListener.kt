package com.example.tikihometest.quicklink

import com.example.tikihometest.model.quicklink.QuickLinkResponse

interface OnGetQuickLinkListFinishListener {
    fun onSuccess(quickLinkResponse: QuickLinkResponse)
    fun onFailure()
}