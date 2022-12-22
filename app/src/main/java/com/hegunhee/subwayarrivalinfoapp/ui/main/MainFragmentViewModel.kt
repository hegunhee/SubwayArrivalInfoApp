package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.lifecycle.*
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayInfoListByFlowUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.InsertSubwayInfoListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.ToggleSubwayInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getSubwayInfoListByFlowUseCase: GetSubwayInfoListByFlowUseCase,
    private val insertSubwayInfoListUseCase: InsertSubwayInfoListUseCase,
    private val toggleSubwayInfoUseCase: ToggleSubwayInfoUseCase
): ViewModel(), MainFragmentActionHandler{

    var _editTextLiveData : MutableLiveData<String> = MutableLiveData<String>("")
    val editTextLiveData : LiveData<String>
        get() = _editTextLiveData

    private val _navigateDetail : MutableSharedFlow<String> = MutableSharedFlow<String>()
    val navigateDetail : SharedFlow<String> = _navigateDetail.asSharedFlow()

    val subwayInfoList : LiveData<List<SubwayInfoEntity>> = editTextLiveData.asFlow().combine(getSubwayInfoListByFlowUseCase()){ str, list ->
        if(editTextLiveData.value == ""){
            return@combine list
        }else{
            return@combine list.filter { str in it.subwayName  }
        }
    }.asLiveData()

    fun insertSubwayList() = viewModelScope.launch(Dispatchers.IO) {
        insertSubwayInfoListUseCase()
    }

    override fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            toggleSubwayInfoUseCase(subwayInfoEntity)
        }
    }

    override fun navigateToDetail(subwayName: String) {
        viewModelScope.launch {
            _navigateDetail.emit(subwayName)
        }
    }
}