package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieContents(
    @Json(name = "data")
    val moviesList: List<MovieListEntry>
)