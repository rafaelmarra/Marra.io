package com.marraps.home_presentation

import androidx.lifecycle.MutableLiveData
import com.marraps.base.BaseViewModel
import com.marraps.home_io.HomeRepository
import com.marraps.models.affixes.Affixes
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel() {

    sealed class GetAffixesState {
        object Loading : GetAffixesState()
        data class Error(val error: Exception) : GetAffixesState()
        data class Success(val response: Affixes) : GetAffixesState()
    }

    val getAffixesState = MutableLiveData<GetAffixesState>()

    fun getAffixes() {
        launch {
            getAffixesState.postValue(GetAffixesState.Loading)

            try {
                val response = repository.getAffixes("us")
                getAffixesState.postValue(GetAffixesState.Success(response))
            } catch (error: Exception) {
                getAffixesState.postValue(GetAffixesState.Error(error))
            }
        }
    }
}