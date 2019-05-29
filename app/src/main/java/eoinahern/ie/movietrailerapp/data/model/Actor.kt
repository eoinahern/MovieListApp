package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Actor(
    val type: String,
    val id: String,
    val numerical_id: Int,
    val photo: String,
    val name: String,
    val born_at: String?
)