package com.sopt.assignment03.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sopt.assignment03.R
import com.sopt.assignment03.data.MyItemData


class InstagramRoomRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<MyItemData>) : RecyclerView.Adapter<InstagramRoomRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
    //뷰 인플레이트!!
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_instagram_room, parent, false)

        return Holder(view)
    }
    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) { //뷰 바인딩!!

        holder.counter.text = dataList[position].counter.toString()
        //holder.isLike.clickable = dataList[position].isLike

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val counter: TextView = itemView.findViewById(R.id.tv_rv_item_instagram_room_cnt) as TextView
        val isLike: ImageView = itemView.findViewById(R.id.tv_rv_item_instagram_room_favorite) as ImageView
    }
}