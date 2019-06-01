package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class GenreImage(
    val icon: String
)