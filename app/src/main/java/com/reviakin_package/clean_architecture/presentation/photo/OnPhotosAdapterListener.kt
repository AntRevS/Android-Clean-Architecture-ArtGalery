package com.reviakin_package.clean_architecture.presentation.photo

import android.widget.ImageView

interface OnPhotosAdapterListener{

    fun gotoDetailPage(imageView: ImageView, id: Long)

}