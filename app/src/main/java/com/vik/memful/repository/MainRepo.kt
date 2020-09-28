package com.vik.memful.repository

import android.content.Context
import com.vik.memful.listener.ResponseListener
import com.vik.memful.model.GalleryResponse
import com.vik.memful.network.RetrofitClient
import com.vik.memful.network.WebAPI
import com.vik.memful.util.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo(val context : Context) {

    fun getGalleryImages(responseListener: ResponseListener<GalleryResponse>) {
        val call = RetrofitClient.getClient()!!.create(WebAPI::class.java)
        call.getGalleryImages(Const.Credentials.CLIENT_ID).enqueue(object : Callback<GalleryResponse>{
            override fun onResponse(
                call: Call<GalleryResponse>,
                response: Response<GalleryResponse>
            ) {
                responseListener.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<GalleryResponse>, t: Throwable) {
                responseListener.onError(t.message!!)
            }
        })
    }

}