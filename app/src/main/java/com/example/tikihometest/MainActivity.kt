package com.example.tikihometest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tikihometest.banner.BannerAdapter
import com.example.tikihometest.banner.BannerContract
import com.example.tikihometest.banner.BannerPresenterImpl
import com.example.tikihometest.flashdeal.FlashDealAdapter
import com.example.tikihometest.flashdeal.FlashDealContract
import com.example.tikihometest.flashdeal.FlashDealPresenterImpl
import com.example.tikihometest.model.banner.BannerResponse
import com.example.tikihometest.model.flashdeal.FlashDealResponse
import com.example.tikihometest.model.quicklink.Data
import com.example.tikihometest.quicklink.QuickLinkAdapter
import com.example.tikihometest.quicklink.QuickLinkContract
import com.example.tikihometest.quicklink.QuickLinkPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(),BannerContract.BannerView,QuickLinkContract.QuickLinkView,FlashDealContract.FlashDealView {

    lateinit var bannerPresenter:BannerContract.BannerPresenter
    lateinit var quickLinkPresenter:QuickLinkContract.QuickLinkPresenter
    lateinit var flashSalePresenter:FlashDealContract.FlashDealPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBannerRcv()
        initQuickLinkRcv()
        initBannerPresenter()
        initQuickLinkPresenter()
        initFlashDealPresenter()
        loadData()
        initFlashDealRcv()
        initScrollToRefresh()
    }

    private fun initScrollToRefresh() {
        swipe_refresh_layout.setOnRefreshListener {
            loadData()
            swipe_refresh_layout.isRefreshing = false
        }
    }
    val uiScope = CoroutineScope(Dispatchers.Main)

    fun loadData() = uiScope.launch {
        showBannerProgress()
        showQuickLinkProgress()
        showFlashDealProgress()
        val task1 = async(Dispatchers.IO) { // background thread
            bannerPresenter.getBanner()
        }

        val task2 = async(Dispatchers.IO) { // background thread
            quickLinkPresenter.callGetQuickLinkList()
        }

        val result1 = task1.await()
        val result2 = task2.await()
        if (result1.isSuccessful){
            showBannerResult(result1.body()!!)
        }
        if(result2.isNotEmpty()){
            showQuickLinkResult(result2)
        }
        hideBannerProgress()
        hideQuickLinkProgress()
        val result3 = withContext(Dispatchers.IO){
            flashSalePresenter.getFlashDealList()
        }
        if(result3.isSuccessful){
            showFlashDealResult(result3.body()!!)
        }
        hideFlashDealProgress()
    }
    override fun initBannerPresenter() {
        bannerPresenter = BannerPresenterImpl(this)
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
    }

    override fun initQuickLinkRcv() {
        rcv_quick_link.layoutManager = GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
    }

    override fun showFlashDealProgress() {
        progress_flash_deal.visibility = View.VISIBLE
        rcv_flash_deal.visibility = View.GONE
    }

    override fun hideFlashDealProgress() {
        progress_flash_deal.visibility = View.GONE
        rcv_flash_deal.visibility = View.VISIBLE
    }

    override fun showFlashDealResult(response: FlashDealResponse) {
        rcv_flash_deal.adapter = FlashDealAdapter(response.data,this)
    }

    override fun initFlashDealPresenter() {
        flashSalePresenter = FlashDealPresenterImpl(this)
    }

    override fun initFlashDealRcv() {
        rcv_flash_deal.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

}
