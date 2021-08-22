package com.reviakin_package.clean_architecture.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reviakin_package.clean_architecture.domain.model.Photo

class PhotoViewModel(val photo: Photo) : ViewModel() {

    private val TAG = PhotoViewModel::class.java.name
    val photoData = MutableLiveData<Photo>()

    init {
        photoData.value = photo
    }

}