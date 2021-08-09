package com.reviakin_package.clean_architecture.repository

import com.reviakin_package.clean_architecture.model.Photo
import io.reactivex.Single

interface PhotoRepository {

    fun getPhotos(albumId: Long?): Single<List<Photo>>

    fun getPhotoDetail(photoId: Long?): Single<Photo>

    fun deletePhoto(photo: Photo)

    fun addPhoto(photo: Photo)

    fun isFavorite(photoId: Long): Boolean
}