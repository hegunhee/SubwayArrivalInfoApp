package com.hegunhee.subwayarrivalinfoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallData
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayArrivalListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSubwayArrivalListUseCase: GetSubwayArrivalListUseCase
) : ViewModel(){

    private var _stationArrivalList : MutableLiveData<List<SubwayArrivalSmallData>> = MutableLiveData(listOf())
    val stationArrivalList : LiveData<List<SubwayArrivalSmallData>>
    get() = _stationArrivalList

    fun initData(station_name : String) = viewModelScope.launch(Dispatchers.IO){
        _stationArrivalList.postValue(getSubwayArrivalListUseCase(station_name))
    }
}