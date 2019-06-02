package eoinahern.ie.movietrailerapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class TrailerData(
    val type: String,
    val id: String,
    val stream_infos: List<StreamInfo>
)