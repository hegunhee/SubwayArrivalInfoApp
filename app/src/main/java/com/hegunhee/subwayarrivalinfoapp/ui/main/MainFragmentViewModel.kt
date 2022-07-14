package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.lifecycle.*
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.GetAllSubwayInfoListByFlowUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.InsertSubwayInfoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getAllSubwayInfoListByFlowUseCase: GetAllSubwayInfoListByFlowUseCase,
    private val insertSubwayInfoListUseCase: InsertSubwayInfoListUseCase
): ViewModel() {

    var _editTextLiveData : MutableLiveData<String> = MutableLiveData<String>("")
    val editTextLiveData : LiveData<String>
        get() = _editTextLiveData

    val subwayInfoList : LiveData<List<SubwayInfoEntity>> = editTextLiveData.asFlow().combine(getAllSubwayInfoListByFlowUseCase()){ str , list ->
        if(editTextLiveData.value == ""){
            return@combine list
        }else{
            return@combine list.filter { str in it.subwayName  }
        }
    }.asLiveData()

    fun insertSubwayList() = viewModelScope.launch(Dispatchers.IO) {
        insertSubwayInfoListUseCase()
    }


}