package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.lifecycle.*
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayInfoListByFlowUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.InsertSubwayInfoListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.ToggleSubwayInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getSubwayInfoListByFlowUseCase: GetSubwayInfoListByFlowUseCase,
    private val insertSubwayInfoListUseCase: InsertSubwayInfoListUseCase,
    private val toggleSubwayInfoUseCase: ToggleSubwayInfoUseCase
): ViewModel(), MainFragmentActionHandler{

    val _searchText : MutableStateFlow<String> = MutableStateFlow<String>("")
    val searchText : StateFlow<String> = _searchText.asStateFlow()

    private val _navigateDetail : MutableSharedFlow<String> = MutableSharedFlow<String>()
    val navigateDetail : SharedFlow<String> = _navigateDetail.asSharedFlow()

    val subwayInfoList : Flow<List<SubwayInfoEntity>> = searchText.combine(getSubwayInfoListByFlowUseCase()){ str, list ->
        if(searchText.value.isBlank()){
            return@combine list
        }else{
            return@combine list.filter { str in it.subwayName  }
        }
    }

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