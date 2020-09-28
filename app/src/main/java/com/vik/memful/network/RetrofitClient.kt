package com.vik.memful.network

import com.google.gson.GsonBuilder
import com.vik.memful.util.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var mRetrofit: Retrofit? = null
    private val mGson = GsonBuilder().setLenient().create()
    private val mHttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val mClient = OkHttpClient.Builder().addInterceptor(mHttpLoggingInterceptor).build();
    fun getClient(): Retrofit? {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .client(mClient)
                .build()
        }
        return mRetrofit
    }

}