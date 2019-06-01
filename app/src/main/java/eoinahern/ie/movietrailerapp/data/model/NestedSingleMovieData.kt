package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NestedSingleMovieData(
    val type: String,
    val id: String,
    val numerical_id: Int,
    val title: String,
    @Json(name = "original_title")
    val OriginalTitle: String,
    val year: Int,
    @Json(name = "short_plot")
    val shortPlot: String,
    val plot: String,
    val duration: Int,
    val duration_in_seconds: Int,
    val actors: List<Actor>,
    val images: MovieImages,
    val scores: List<Score>,
    val genres : List<Genre>
)