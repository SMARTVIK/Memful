package com.vik.memful.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vik.memful.listener.ResponseListener
import com.vik.memful.model.GalleryResponse
import com.vik.memful.repository.MainRepo

class MainViewModel(val mainRepo : MainRepo) : ViewModel() {

      private val galleryResponse : MutableLiveData<GalleryResponse> = MutableLiveData()

      fun getGalleryResponse() : LiveData<GalleryResponse> {
          return galleryResponse
      }


      fun getGalleryImages() : LiveData<GalleryResponse>{


          mainRepo.getGalleryImages(object : ResponseListener<GalleryResponse>{
              override fun onSuccess(t: GalleryResponse) {
                  galleryResponse.postValue(t)
              }

              override fun onError(error: String) {
                  galleryResponse.postValue(null)
              }
          })

          return galleryResponse!!
      }

}