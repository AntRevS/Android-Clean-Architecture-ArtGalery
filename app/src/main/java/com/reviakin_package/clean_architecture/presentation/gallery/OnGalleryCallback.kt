package com.reviakin_package.clean_architecture.presentation.gallery

import android.widget.ImageView
import com.reviakin_package.clean_architecture.domain.model.Album

interface OnGalleryCallback {

    fun navigateToAlbumPage(album: Album)

    fun gotroDetailPageByPhotoId(imageView: ImageView, id: Long)
}