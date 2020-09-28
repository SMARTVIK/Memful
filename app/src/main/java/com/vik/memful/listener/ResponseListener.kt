package com.vik.memful.listener

interface ResponseListener<T> {
    fun onSuccess(t: T)
    fun onError(error: String)
}