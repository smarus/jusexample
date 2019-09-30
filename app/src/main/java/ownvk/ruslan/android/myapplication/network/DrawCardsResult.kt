package ownvk.ruslan.android.myapplication.network

import com.squareup.moshi.Json
import java.util.ArrayList


data class DrawCardsResult(
    private var success: Boolean = false,
    var cards: ArrayList<Card> = ArrayList<Card>(),
    @Json(name = "deck_id")
    var deckId: String? = null,
    var remaining: Int = 0
)

data class Card (
    private var image: String?,
    private var value: String?,
    private var suit: String?,
    private var code: String?
)
