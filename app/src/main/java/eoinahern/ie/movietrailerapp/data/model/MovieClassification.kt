package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieClassification(
    val type: String,
    val id: String,
    val name: String,
    val age: Int,
    val adult: Boolean,
    val description: String
)