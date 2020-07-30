package com.example.tikihometest.quicklink

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tikihometest.R
import com.example.tikihometest.model.quicklink.Data
import com.example.tikihometest.model.quicklink.QuickLinkResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_quick_link.view.*

class QuickLinkAdapter(
    var dataList: List<Data>,
    context: Context
) :
    RecyclerView.Adapter<QuickLinkAdapter.QuickLinkHolder>() {
    var context: Context = context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuickLinkHolder {
        val v: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_item_quick_link, parent, false)
        return QuickLinkHolder(v)
    }

    override fun onBindViewHolder(
        holder: QuickLinkHolder,
        position: Int
    ) {
        Picasso.get().load(dataList[position].image_url).into(holder.iv_quick_link)
        holder.tv_quick_link_title.text = dataList[position].title
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class QuickLinkHolder(v: View) : RecyclerView.ViewHolder(v) {
        var iv_quick_link = v.iv_quick_link
        var tv_quick_link_title = v.tv_quick_link
        var view = v
    }

}