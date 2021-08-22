package com.reviakin_package.clean_architecture.presentation.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reviakin_package.clean_architecture.domain.model.Album
import com.reviakin_package.clean_architecture.domain.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val getAlbumListUseCase: GetAlbumsUseCase
) : ViewModel() {

    private val TAG = AlbumsViewModel::class.java.simpleName
    val albumsReceivedLiveData = MutableLiveData<List<Album>>()
    val isLoad = MutableLiveData<Boolean>()
    val albumData = MutableLiveData<Album>()

    init {
        isLoad.value = false
    }

    val album: Album? get() = albumData.value

    fun set(album: Album) = kotlin.run { albumData.value = album }

    fun loadAlbums(){
        getAlbumListUseCase.execute(
            onSuccess = {
                isLoad.value = true
                albumsReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

}