package com.example.tikihometest.flashdeal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tikihometest.R
import com.example.tikihometest.model.flashdeal.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_flash_deal.view.*

class FlashDealAdapter(
    var flashDealList: List<Data>,
    context: Context
) :
    RecyclerView.Adapter<FlashDealAdapter.FlashDealHolder>() {
    var context: Context = context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlashDealHolder {
        val v: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_item_flash_deal, parent, false)
        return FlashDealHolder(v)
    }

    override fun onBindViewHolder(
        holder: FlashDealHolder,
        position: Int
    ) {
        Picasso.get().load(flashDealList[position].product.thumbnail_url).into(holder.iv_image)
        holder.tv_price.text = flashDealList[position].product.price.toString()
        holder.tv_sale_percent.text = "-"+flashDealList[position].discount_percent.toString()+"%"
        holder.sale_progress_bar.max = flashDealList[position].progress.qty
        holder.sale_progress_bar.progress = flashDealList[position].progress.qty_ordered
        if(flashDealList[position].progress.percent >= 95){
            holder.tv_sale_status.text = "Vừa mở bán"
        }
        else {
            holder.tv_sale_status.text = "Đã bán "+flashDealList[position].progress.qty_ordered
        }
    }

    override fun getItemCount(): Int {
        return flashDealList.size
    }

    inner class FlashDealHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view = v
        var iv_image = v.iv_image
        var tv_sale_percent = v.tv_sale_percent
        var tv_price = v.tv_price
        var sale_progress_bar = v.sale_progress_bar
        var tv_sale_status = v.tv_sale_status

    }

}