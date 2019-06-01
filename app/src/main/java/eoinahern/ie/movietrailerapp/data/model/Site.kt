package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Site(
    val type: String,
    val name: String,
    val image: String,
    val scale: Float

)