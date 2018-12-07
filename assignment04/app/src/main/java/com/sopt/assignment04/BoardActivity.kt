package com.sopt.assignment04

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.sopt.assignment04.adapter.BoardRecyclerViewAdapter
import com.sopt.assignment04.data.BoardData
import com.sopt.assignment04.get.GetBoardListResponse
import com.sopt.assignment04.network.ApplicationController
import com.sopt.assignment04.network.NetworkService
import kotlinx.android.synthetic.main.activity_board.*
import org.jetbrains.anko.startActivityForResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoardActivity : AppCompatActivity() {
    val WRITE_ACTIVITY_REQUEST_CODE = 1000
    lateinit var boardRecyclerViewAdapter: BoardRecyclerViewAdapter

    val dataList : ArrayList<BoardData> by lazy {
        ArrayList<BoardData>()
    }
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        //
        setOnBtnClickListener()

        setRecyclerView()

        //통신
        getBoardListResponse()

    }

    private fun setRecyclerView(){
        boardRecyclerViewAdapter = BoardRecyclerViewAdapter(this, dataList)
        rv_board_act_board_list.adapter = boardRecyclerViewAdapter
        rv_board_act_board_list.layoutManager = LinearLayoutManager(this)
    }


    //통신
    private fun getBoardListResponse(){
        val getBoardListResponse = networkService.getBoardListResponse("application/json", 0, 30)
        getBoardListResponse.enqueue(object : Callback<GetBoardListResponse> {

            //실패
            override fun onFailure(call: Call<GetBoardListResponse>, t: Throwable) {
                Log.e("board list fail", t.toString())
            }

            //성공
            override fun onResponse(call: Call<GetBoardListResponse>, response: Response<GetBoardListResponse>) {
                if (response.isSuccessful){
                    val temp : ArrayList<BoardData> = response.body()!!.data
                    if (temp.size > 0){
                        val position = boardRecyclerViewAdapter.itemCount
                        boardRecyclerViewAdapter.dataList.addAll(temp)
                        boardRecyclerViewAdapter.notifyItemInserted(position)
                    }
                }
            }
        })
    }

    //
    private fun setOnBtnClickListener(){
        btn_detailed_act_write.setOnClickListener {
            startActivityForResult<WriteActivity>(WRITE_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == WRITE_ACTIVITY_REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                //리스트 비우기
                boardRecyclerViewAdapter.dataList.clear()
                boardRecyclerViewAdapter.notifyDataSetChanged()
                //재통신
                getBoardListResponse()
            }
        }
    }
}