package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieListEntry(
    val type: String,
    val id: String,
    val numerical_id: Int,
    val title: String,
    val year: Int,
    val duration: Int,
    val label: String,
    @Json(name = "classification")
    val classification: MovieClassification,
    @Json(name = "images")
    val images: MovieImages,
    @Json(name = "highlighted_score")
    val highlightedScore: Map<String, Int>,
    @Json(name = "rating")
    val rating: Map<String, Int>
)