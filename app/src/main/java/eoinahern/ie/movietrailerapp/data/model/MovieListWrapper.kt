package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListWrapper(
    @Json(name = "type")
    val type: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "numerical_id")
    val numericalID: Int,
    @Json(name = "contents")
    val contents: List<MovieListEntry>
)