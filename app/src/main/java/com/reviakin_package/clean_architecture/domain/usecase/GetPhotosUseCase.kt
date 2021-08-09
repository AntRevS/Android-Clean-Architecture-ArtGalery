package com.reviakin_package.clean_architecture.domain.usecase

import com.reviakin_package.clean_architecture.domain.model.Photo
import com.reviakin_package.clean_architecture.domain.repository.PhotoRepository
import com.reviakin_package.clean_architecture.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val repository: PhotoRepository) : SingleUseCase<List<Photo>>() {

    private var albumId: Long? = null

    fun saveAlbumId(id: Long){
        albumId = id
    }

    override fun buildUseCaseSingle(): Single<List<Photo>> {
        return repository.getPhotos(albumId)
    }
}