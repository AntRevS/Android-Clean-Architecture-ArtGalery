package com.reviakin_package.clean_architecture.data.repository

import com.reviakin_package.clean_architecture.domain.model.Photo
import com.reviakin_package.clean_architecture.domain.repository.PhotoRepository
import com.reviakin_package.clean_architecture.data.source.local.AppDatabase
import com.reviakin_package.clean_architecture.data.source.remote.RetrofitService
import io.reactivex.Single

class PhotoRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
): PhotoRepository {

    override fun getPhotos(albumId: Long?): Single<List<Photo>> {
        return retrofitService.getPhotos(albumId!!)
    }

    override fun getPhotoDetail(photoId: Long?): Single<Photo> {
        TODO("Not yet implemented")
    }

    override fun deletePhoto(photo: Photo) {
        TODO("Not yet implemented")
    }

    override fun addPhoto(photo: Photo) {
        TODO("Not yet implemented")
    }

    override fun isFavorite(photoId: Long): Boolean {
        TODO("Not yet implemented")
    }
}