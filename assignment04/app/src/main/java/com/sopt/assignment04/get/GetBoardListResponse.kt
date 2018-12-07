package com.sopt.assignment04.get

import com.sopt.assignment04.data.BoardData

data class GetBoardListResponse(
    val status : Int,
    val message : String,
    val data : ArrayList<BoardData>
)