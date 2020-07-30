package com.example.tikihometest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tikihometest.banner.BannerAdapter
import com.example.tikihometest.banner.BannerContract
import com.example.tikihometest.banner.BannerPresenterImpl
import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.model.quicklink.Data
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import com.example.tikihometest.quicklink.QuickLinkAdapter
import com.example.tikihometest.quicklink.QuickLinkContract
import com.example.tikihometest.quicklink.QuickLinkPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BannerContract.BannerView,QuickLinkContract.QuickLinkView {

    lateinit var bannerPresenter:BannerContract.BannerPresenter
    lateinit var quickLinkPresenter:QuickLinkContract.QuickLinkPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBannerRcv()
        initBannerPresenter()
        initQuickLinkRcv()
        initQuickLinkPresenter()
        initScrollToRefresh()
    }

    private fun initScrollToRefresh() {
        swipe_refresh_layout.setOnRefreshListener {
            bannerPresenter.getBanner()
            quickLinkPresenter.callGetQuickLinkList()
            swipe_refresh_layout.isRefreshing = false
        }
    }

    override fun initBannerPresenter() {
        bannerPresenter = BannerPresenterImpl(this)
        bannerPresenter.getBanner()
    }
    override fun initBannerRcv(){
        rcv_banner.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun showBannerProgress() {
        rcv_banner.visibility = View.GONE
        progress_banner.visibility = View.VISIBLE
    }

    override fun hideBannerProgress() {
        rcv_banner.visibility = View.VISIBLE
        progress_banner.visibility = View.GONE
    }

    override fun showBannerResult(response: BannerResponse) {
        rcv_banner.adapter = BannerAdapter(response.data,this)
    }

    override fun showQuickLinkProgress() {
        rcv_quick_link.visibility = View.GONE
        progress_quick_link.visibility = View.VISIBLE
    }

    override fun hideQuickLinkProgress() {
        rcv_quick_link.visibility = View.VISIBLE
        progress_quick_link.visibility = View.GONE
    }

    override fun showQuickLinkResult(dataList: List<Data>) {
        rcv_quick_link.adapter = QuickLinkAdapter(dataList,this)
    }

    override fun initQuickLinkPresenter() {
        quickLinkPresenter = QuickLinkPresenterImpl(this)
        quickLinkPresenter.callGetQuickLinkList()
    }

    override fun initQuickLinkRcv() {
        rcv_quick_link.layoutManager = GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
//        rcv_quick_link.layoutDirection = View.LAYOUT_DIRECTION_RTL
    }

}
