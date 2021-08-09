package com.reviakin_package.clean_architecture.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Photo")
data class Photo(
    @PrimaryKey var id: Long,
    var title: String,
    var url: String,
    var thumbnailUrl: String?
){
    fun setName(text: String){
        title = text
    }
}