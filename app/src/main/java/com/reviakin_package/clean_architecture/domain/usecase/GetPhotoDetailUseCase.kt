package com.reviakin_package.clean_architecture.domain.usecase

import com.reviakin_package.clean_architecture.domain.model.Photo
import com.reviakin_package.clean_architecture.domain.repository.PhotoRepository
import com.reviakin_package.clean_architecture.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(private val repository: PhotoRepository) : SingleUseCase<Photo>() {

    private var photoId: Long? = null

    fun savePhotoId(id: Long){
        photoId = id
    }

    fun adAsFavorite(photo: Photo){
        repository.addPhoto(photo)
    }

    fun deleteAsFavorite(photo: Photo){
        repository.deletePhoto(photo)
    }

    fun isFavorite(photoId: Long): Boolean{
        return repository.isFavorite(photoId)
    }

    override fun buildUseCaseSingle(): Single<Photo> {
        return repository.getPhotoDetail(photoId)
    }
}