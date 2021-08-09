package com.reviakin_package.clean_architecture.domain.repository

import com.reviakin_package.clean_architecture.domain.model.Album
import io.reactivex.Single

interface AlbumRepository {

    fun getAlbums(): Single<List<Album>>
}