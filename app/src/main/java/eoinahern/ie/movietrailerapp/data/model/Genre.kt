package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Genre(
    val id: String,
    val name: String,
    val additional_images: GenreImage
)