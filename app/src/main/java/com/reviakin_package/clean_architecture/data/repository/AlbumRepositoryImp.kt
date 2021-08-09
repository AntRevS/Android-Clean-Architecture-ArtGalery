package com.reviakin_package.clean_architecture.data.repository

import com.reviakin_package.clean_architecture.domain.model.Album
import com.reviakin_package.clean_architecture.domain.repository.AlbumRepository
import com.reviakin_package.clean_architecture.data.source.remote.RetrofitService
import io.reactivex.Single

class AlbumRepositoryImp(
    private val retrofitService: RetrofitService
): AlbumRepository {

    override fun getAlbums(): Single<List<Album>> {
        return retrofitService.getAlbums()
    }
}