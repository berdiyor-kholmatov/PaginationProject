package com.example.paginationproject.network.imageResponse

import com.example.paginationproject.damain.model.Image
import com.example.paginationproject.damain.util.Mapper

class ImageResponseMapper(): Mapper<ImageListModelItem, Image> {
    override fun modelToDomain(domain: Image): ImageListModelItem {
        TODO("Not yet implemented")
    }

    override fun domainToModel(model: ImageListModelItem): Image {
        return Image(
            id = model.id,
            author = model.author,
            width = model.width,
            height = model.height,
            url = model.url,
            download_url = model.download_url,
        )
    }

}