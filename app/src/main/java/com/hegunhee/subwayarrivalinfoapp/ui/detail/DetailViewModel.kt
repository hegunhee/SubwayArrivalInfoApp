package com.hegunhee.subwayarrivalinfoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallData
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.domain.GetSortedSubwayArrivalListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayArrivalListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSubwayArrivalListUseCase: GetSubwayArrivalListUseCase,
    private val getSortedSubwayArrivalListUseCase: GetSortedSubwayArrivalListUseCase
) : ViewModel(){

    private var _stationArrivalList : MutableLiveData<List<SubwayArrivalSmallDataWithStationLine>> = MutableLiveData(listOf())
    val stationArrivalList : LiveData<List<SubwayArrivalSmallDataWithStationLine>>
    get() = _stationArrivalList

    fun initData(station_name : String) = viewModelScope.launch(Dispatchers.IO){
        _stationArrivalList.postValue(getSortedSubwayArrivalListUseCase(station_name))
    }
}