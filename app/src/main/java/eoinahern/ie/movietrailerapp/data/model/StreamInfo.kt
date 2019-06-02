package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class StreamInfo(
    val player: String,
    val cdn: String,
    val url: String,
    val video_quality: String
)