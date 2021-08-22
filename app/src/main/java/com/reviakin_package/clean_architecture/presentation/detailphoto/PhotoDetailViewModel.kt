package com.reviakin_package.clean_architecture.presentation.detailphoto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reviakin_package.clean_architecture.domain.model.Photo
import com.reviakin_package.clean_architecture.domain.usecase.GetPhotoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase
): ViewModel() {

    private val TAG = PhotoDetailViewModel::class.java.simpleName
    val photoData = MutableLiveData<Photo>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun getDetail(id: Long?){
        if(id == null) return
        getPhotoDetailUseCase.savePhotoId(id)
        getPhotoDetailUseCase.execute(
            onSuccess = {
                isLoad.value = true
                photoData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun updateFavoriteStatus(){
        photoData.value?.let { photo ->
            if(isFavorite.value == true){
                getPhotoDetailUseCase.deleteAsFavorite(photo)
            }else{
                getPhotoDetailUseCase.adAsFavorite(photo)
            }
            isFavorite.value?.let {
                isFavorite.value = !it
            }
        }
    }

    fun checkFavoriteStatus(photoId: Long){
        isFavorite.value = getPhotoDetailUseCase.isFavorite(photoId)
    }

}