package com.reviakin_package.clean_architecture.repository

import com.reviakin_package.clean_architecture.model.Album
import io.reactivex.Single

interface AlbumRepository {

    fun getAlbums(): Single<List<Album>>
}