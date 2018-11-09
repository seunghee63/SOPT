package com.sopt.assignment03

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.sopt.assignment03.adapter.InstagramRoomRecyclerViewAdapter
import com.sopt.assignment03.data.MyItemData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var InstagramRoomRecyclerViewAdapter: InstagramRoomRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
    }

    private fun setRecyclerView(){

        //val anyDataList : ArrayList<Any> = arrayListOf("dtdt")//자바의 object. 최상위 데이터타입


        //임시데이터
        var dataList: ArrayList<MyItemData> = ArrayList()
        dataList.add(MyItemData(1, false))
        dataList.add(MyItemData(2, false))
        dataList.add(MyItemData(3, false))
        dataList.add(MyItemData(4, false))
        dataList.add(MyItemData(5, false))
        dataList.add(MyItemData(6, false))
        dataList.add(MyItemData(7, false))
        dataList.add(MyItemData(8, false))
        dataList.add(MyItemData(9, false))
        dataList.add(MyItemData(10, false))
        dataList.add(MyItemData(11, false))
        dataList.add(MyItemData(12, false))
        dataList.add(MyItemData(13, false))
        dataList.add(MyItemData(14, false))

        InstagramRoomRecyclerViewAdapter  = InstagramRoomRecyclerViewAdapter(this, dataList)
        rv_main_activity_instagram_room_list.adapter = InstagramRoomRecyclerViewAdapter
        rv_main_activity_instagram_room_list.layoutManager = GridLayoutManager(this, 3)

    }
}
