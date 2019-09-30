package ownvk.ruslan.android.myapplication.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://deckofcardsapi.com/api/deck/"



private val moshi = Moshi.Builder()
        .build()

private val retrofit by lazy {
    Retrofit.Builder()
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()
}


interface ApiService{

    @GET("new/shuffle/")
    abstract fun shuffleDecks(@Query("deck_count") deckCount: Int): Deferred<ShuffleResult>

    @GET("{deck_id}/draw/")
    abstract fun drawCards(@Path("deck_id") deckId: String, @Query("count") count: Int): Deferred<DrawCardsResult>

    @GET("{deck_id}/shuffle/")
    abstract fun reshuffleDeck(@Path("deck_id") deckId: String): Deferred<ShuffleResult>

}

object DecksApi{
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}