package com.vik.memful.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vik.memful.repository.MainRepo

class MainViewModelFactory(val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repo = MainRepo(context)
        return modelClass.getConstructor(MainRepo::class.java).newInstance(repo)
    }
}