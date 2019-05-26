package eoinahern.ie.movietrailerapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class MovieImages(
    @Json(name = "artwork")
    val artwork: String,
    @Json(name = "snapshot")
    val snapshot: String
) : Parcelable