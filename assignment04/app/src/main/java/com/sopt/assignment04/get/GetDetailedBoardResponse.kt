package com.sopt.assignment04.get

import com.sopt.assignment04.data.BoardData

data class GetDetailedBoardResponse(
    val status : String,
    val message : String,
    val data : BoardData
)