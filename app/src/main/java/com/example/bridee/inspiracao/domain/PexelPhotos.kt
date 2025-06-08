package com.example.bridee.inspiracao.domain

import java.time.LocalDateTime

data class PexelPhotos(
    var id: Long,
    val photographer: String,
    val photographerUrl: String,
    val photographerId: String,
    val source: PhotoSource,
    val altText: String,
    var favorite: Boolean
){
    fun toImageMetadata(): ImageMetadata{
        val originalSource = source.small.split(".")
        val extensao = originalSource[originalSource.size - 1]
        return ImageMetadata(
            nome = altText.plus(LocalDateTime.now().toString()),
            url = source.small,
            extensao = extensao
        )
    }

}
