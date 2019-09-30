package ownvk.ruslan.android.myapplication.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShuffleResult(
    var success: Boolean = false,
    @Json(name = "deck_id")
    var deckId: String? = null,
    var shuffled: Boolean = false,
    var remaining: Int = 0
): Parcelable

