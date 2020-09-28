package com.vik.memful.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.vik.memful.R

class CustomProgressDialog(context: Context, isCancelable: Boolean) : Dialog(context) {
    init {
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_progress_bar)
        setCancelable(isCancelable)
    }

}