package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Genre(
    val id: String,
    val name: String,
    @Json(name = "additional_images")
    val additional_images: GenreImage
)