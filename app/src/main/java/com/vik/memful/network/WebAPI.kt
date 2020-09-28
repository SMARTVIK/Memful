package com.vik.memful.network

import com.vik.memful.model.GalleryResponse
import com.vik.memful.util.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Header

interface WebAPI {
    @GET("top/top/day/1?showViral=true&mature=true&album_previews=true")
    fun getGalleryImages(@Header("Authorization") authorization: String) : Call<GalleryResponse>
}