package com.hegunhee.subwayarrivalinfoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.DeleteFavoritesUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.GetSortedSubwayArrivalListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.InsertFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSortedSubwayArrivalListUseCase: GetSortedSubwayArrivalListUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase,
    private val insertFavoritesUseCase: InsertFavoritesUseCase
) : ViewModel(), DetailFragmentActionHandler{

    private val _stationArrivalListState : MutableStateFlow<SubwayArrivalListState> = MutableStateFlow(SubwayArrivalListState.Initialized)
    val stationArrivalListState : StateFlow<SubwayArrivalListState> = _stationArrivalListState.asStateFlow()

    fun fetchSubwayArrivalInfo(station_name : String) = viewModelScope.launch{
        getSortedSubwayArrivalListUseCase(station_name).onSuccess {
            _stationArrivalListState.emit(SubwayArrivalListState.Success(it))
        }.onFailure {
            _stationArrivalListState.emit(SubwayArrivalListState.Failure)
        }
    }

    override fun toggleFavorite(subwayArrivalData: SubwayArrivalInfo, stationName : String) {
        viewModelScope.launch(Dispatchers.IO) {
            if(subwayArrivalData.isFavorite){
                deleteFavoritesUseCase(subwayArrivalData.fullName)
            }else{
                insertFavoritesUseCase(subwayArrivalData.toFavorites(stationName))
            }
            fetchSubwayArrivalInfo(stationName)
        }

    }
}