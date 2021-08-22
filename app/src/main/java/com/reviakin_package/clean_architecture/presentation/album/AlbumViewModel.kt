package com.reviakin_package.clean_architecture.presentation.album

import androidx.lifecycle.MutableLiveData
import com.reviakin_package.clean_architecture.domain.model.Album

class AlbumViewModel(val album: Album) {

    private val TAG = AlbumViewModel::class.java.simpleName
    val albumData = MutableLiveData<Album>()

    init {
        albumData.value = album
    }
}