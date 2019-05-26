package eoinahern.ie.movietrailerapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


@Parcelize
@JsonClass(generateAdapter = true)
data class HighlightedScore(
    @Json(name = "score")
    val score: Float,
    @Json(name = "amount_of_votes")
    val amountOfVotes: Int,
    @Json(name = "formatted_amount_of_votes")
    val formattedAmountVotes: String
) : Parcelable