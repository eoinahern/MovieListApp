package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class SingleMovieItem(
    @Json(name = "data")
    val nestedData: NestedSingleMovieData


)