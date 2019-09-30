package ownvk.ruslan.android.myapplication

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ownvk.ruslan.android.myapplication.network.DecksApi
import ownvk.ruslan.android.myapplication.network.ShuffleResult
import java.lang.Exception

class CardViewModel() : ViewModel(){

    private val _shufleDecks = MutableLiveData<ShuffleResult>()

    val shufleDec : LiveData<ShuffleResult>
    get() =  _shufleDecks

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
         getShufleDecs()
    }


    private fun getShufleDecs(){

        coroutineScope.launch {
            var shufleDecks = DecksApi.retrofitService.shuffleDecks(4)
            try {
                _shufleDecks.value = shufleDecks.await()
            }catch (e : Exception){
                _shufleDecks.value = null
            }
        }
    }

}