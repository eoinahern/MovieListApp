package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieImages(
    @Json(name = "artwork")
    val artwork: String,
    @Json(name = "snapshot")
    val snapshot: String
)