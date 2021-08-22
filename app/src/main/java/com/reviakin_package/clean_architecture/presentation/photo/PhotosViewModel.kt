package com.reviakin_package.clean_architecture.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reviakin_package.clean_architecture.domain.model.Photo
import com.reviakin_package.clean_architecture.domain.usecase.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {

    private val TAG = PhotosViewModel::class.java.simpleName
    val photoListReceivedLiveData = MutableLiveData<List<Photo>>()
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }


    fun loadPhotos(id: Long?) {
        if (id == null) return
        getPhotosUseCase.saveAlbumId(id)
        getPhotosUseCase.execute(
            onSuccess = {
                isLoad.value = true
                photoListReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}