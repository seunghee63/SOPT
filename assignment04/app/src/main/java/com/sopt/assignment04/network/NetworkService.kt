package com.sopt.assignment04.network

import com.sopt.assignment04.get.GetBoardListResponse
import com.sopt.assignment04.get.GetDetailedBoardResponse
import com.sopt.assignment04.post.PostWriteBoardResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    //게시판 글쓰기
    @Multipart
    @POST("/contents")
    fun postWriteBoardResponse(
        @Header("Authorization") token : String,
        @Part("title") title : RequestBody,
        @Part("contents") contents : RequestBody,
        @Part photo: MultipartBody.Part?
    ) : Call<PostWriteBoardResponse>


    //모든 게시판 보기
    @GET("/contents")
    fun getBoardListResponse(
        @Header("Content-Type") content_type : String,
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ) : Call<GetBoardListResponse>

    //게시물 상세 보기
    @GET("/contents/{contentIdx}")
    fun getDetailedBoardResponse(
        @Header("Content-Type") content_type : String,
        @Header("Authorization") token : String,
        @Path("contentIdx") contentIdx : Int
    ) : Call<GetDetailedBoardResponse>



}