package com.hegunhee.subwayarrivalinfoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallData
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.domain.DeleteFavoritesUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.GetSortedSubwayArrivalListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayArrivalListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.InsertFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSortedSubwayArrivalListUseCase: GetSortedSubwayArrivalListUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase,
    private val insertFavoritesUseCase: InsertFavoritesUseCase
) : ViewModel(), DetailFragmentActionHandler{

    private var _stationArrivalList : MutableLiveData<List<SubwayArrivalSmallDataWithStationLine>> = MutableLiveData(listOf())
    val stationArrivalList : LiveData<List<SubwayArrivalSmallDataWithStationLine>>
    get() = _stationArrivalList

    fun initData(station_name : String) = viewModelScope.launch(Dispatchers.IO){
        _stationArrivalList.postValue(getSortedSubwayArrivalListUseCase(station_name))
    }

    override fun deleteFavorite(station_info : String) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFavoritesUseCase(station_info)
        }
    }

    override fun insertFavorite(favorites: Favorites) {
        viewModelScope.launch(Dispatchers.IO) {
            insertFavoritesUseCase(favorites)
        }
    }
}