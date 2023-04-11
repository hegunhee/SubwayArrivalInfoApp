package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.lifecycle.*
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayInfoListByFlowUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.InsertSubwayInfoListUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.ToggleSubwayInfoBookMarkedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getSubwayInfoListByFlowUseCase: GetSubwayInfoListByFlowUseCase,
    private val insertSubwayInfoListUseCase: InsertSubwayInfoListUseCase,
    private val toggleSubwayInfoBookMarkedUseCase: ToggleSubwayInfoBookMarkedUseCase
): ViewModel(), MainFragmentActionHandler{

    val _searchText : MutableStateFlow<String> = MutableStateFlow<String>("")
    val searchText : StateFlow<String> = _searchText.asStateFlow()

    private val _navigateDetail : MutableSharedFlow<String> = MutableSharedFlow<String>()
    val navigateDetail : SharedFlow<String> = _navigateDetail.asSharedFlow()

    val subwayInfoList : Flow<List<SubwayInfoEntity>> = searchText.combine(getSubwayInfoListByFlowUseCase()){ str, list ->
        return@combine if(searchText.value.isBlank()) {
            list
        } else
            list.filter { str in it.subwayName }
    }

    fun insertSubwayList() = viewModelScope.launch {
        insertSubwayInfoListUseCase()
    }

    override fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            toggleSubwayInfoBookMarkedUseCase(subwayInfoEntity.copy(isBookmarked = !subwayInfoEntity.isBookmarked))
        }
    }

    override fun navigateToDetail(subwayName: String) {
        viewModelScope.launch {
            _navigateDetail.emit(subwayName)
        }
    }
}