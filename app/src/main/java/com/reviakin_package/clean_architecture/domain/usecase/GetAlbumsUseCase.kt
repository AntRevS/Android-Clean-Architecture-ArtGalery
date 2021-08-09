package com.reviakin_package.clean_architecture.domain.usecase

import com.reviakin_package.clean_architecture.domain.model.Album
import com.reviakin_package.clean_architecture.domain.repository.AlbumRepository
import com.reviakin_package.clean_architecture.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private val repository: AlbumRepository) : SingleUseCase<List<Album>>() {

    override fun buildUseCaseSingle(): Single<List<Album>> {
        return repository.getAlbums()
    }
}