package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.domain.GetFavoriteSubwayInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteDetailViewModel @Inject constructor(
    private val getFavoriteSubwayInfoUseCase: GetFavoriteSubwayInfoUseCase
) : ViewModel() {

    private var _subwayInfoList: MutableLiveData<List<SubwayArrivalSmallDataWithStationLine>> = MutableLiveData(listOf())
    val subwayInfoList : LiveData<List<SubwayArrivalSmallDataWithStationLine>>
    get() = _subwayInfoList



    fun getFavoriteSubwayInfo(favorites: Favorites) = viewModelScope.launch(Dispatchers.IO) {
        _subwayInfoList.postValue(getFavoriteSubwayInfoUseCase(favorites))
    }
}