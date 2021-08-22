package com.reviakin_package.clean_architecture.presentation.album

import com.reviakin_package.clean_architecture.domain.model.Album

interface OnAlbumsAdapterListener {

    fun showPhotos(album: Album)
    
}