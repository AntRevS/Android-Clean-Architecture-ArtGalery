package com.reviakin_package.clean_architecture.remote

import android.provider.ContactsContract
import com.reviakin_package.clean_architecture.model.Album
import com.reviakin_package.clean_architecture.model.Photo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("albums/")
    fun getAlbums(): Single<List<Album>>

    @GET("albums/{id}/photos")
    fun getPhotos(@Path("id") id: Long): Single<List<ContactsContract.Contacts.Photo>>

    @GET("photos/{id}")
    fun getPhotoDetail(@Path("id") id: Long): Single<Photo>

}