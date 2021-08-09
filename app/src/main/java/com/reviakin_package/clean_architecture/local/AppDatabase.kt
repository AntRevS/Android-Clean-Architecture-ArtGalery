package com.reviakin_package.clean_architecture.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.reviakin_package.clean_architecture.local.dao.PhotoDao
import com.reviakin_package.clean_architecture.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val photoDao: PhotoDao

    companion object{
        const val DB_NAME = "ArtGalleryDatabase.db"
    }
}