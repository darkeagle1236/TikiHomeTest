package com.example.tikihometest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tikihometest.banner.BannerAdapter
import com.example.tikihometest.banner.BannerContract
import com.example.tikihometest.banner.BannerPresenterImpl
import com.example.tikihometest.model.banner.BannerResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BannerContract.BannerView {

    lateinit var presenter:BannerContract.BannerPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBannerRcv()
        initPresenter()
        initScrollToRefresh()
    }

    private fun initScrollToRefresh() {
        swipe_refresh_layout.setOnRefreshListener {
            presenter.getBanner()
            swipe_refresh_layout.isRefreshing = false
        }
    }

    override fun initPresenter() {
        presenter = BannerPresenterImpl(this)
        presenter.getBanner()
    }
    private fun initBannerRcv(){
        rcv_banner.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun showProgress() {
        rcv_banner.visibility = View.GONE
        progress_banner.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        rcv_banner.visibility = View.VISIBLE
        progress_banner.visibility = View.GONE
    }

    override fun showResults(response: BannerResponse) {
        rcv_banner.adapter = BannerAdapter(response.data,this)
    }

}
