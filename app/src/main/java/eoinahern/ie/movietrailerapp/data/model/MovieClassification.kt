package eoinahern.ie.movietrailerapp.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class MovieClassification(
    val type: String,
    val id: String,
    val name: String,
    val age: Int,
    val adult: Boolean,
    val description: String
) : Parcelable