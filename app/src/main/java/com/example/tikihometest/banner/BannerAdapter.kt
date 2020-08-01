package com.example.tikihometest.banner

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tikihometest.R
import com.example.tikihometest.model.banner.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_banner.view.*


class BannerAdapter(
    var bannerList: List<Data>,
    context: Context
) :
    RecyclerView.Adapter<BannerAdapter.BannerHolder>() {
    var context: Context = context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerHolder {
        val v: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_item_banner, parent, false)
        return BannerHolder(v)
    }

    override fun onBindViewHolder(
        holder: BannerHolder,
        position: Int
    ) {
        Picasso.get().load(bannerList[position].mobile_url).into(holder.iv_banner)
        holder.itemView.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(bannerList[position].url)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

    inner class BannerHolder(v: View) : RecyclerView.ViewHolder(v) {
        var iv_banner = v.iv_banner
        var view = v
    }

}