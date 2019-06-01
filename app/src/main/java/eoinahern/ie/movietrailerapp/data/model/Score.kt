package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Score(
    val type: String,
    val id: String,
    val numerical_id: Int,
    val href: String,
    val amount_of_votes: Int,
    val formatted_amount_of_votes: String,
    val score: Float,
    val highlighted: Boolean,
    val site: Site
)