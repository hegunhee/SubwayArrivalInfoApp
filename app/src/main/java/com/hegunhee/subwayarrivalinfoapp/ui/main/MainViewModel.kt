package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.lifecycle.*
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.SaveAllSubwayListInLocalDBUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.GetSubwayInfoListByFlowUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.ToggleSubwayInfoBookMarkedUseCase
import com.hegunhee.subwayarrivalinfoapp.network.networkErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSubwayInfoListByFlowUseCase: GetSubwayInfoListByFlowUseCase,
    private val saveAllSubwayListInLocalDBUseCase: SaveAllSubwayListInLocalDBUseCase,
    private val toggleSubwayInfoBookMarkedUseCase: ToggleSubwayInfoBookMarkedUseCase
): ViewModel(), MainActionHandler{

    val searchText : MutableStateFlow<String> = MutableStateFlow("")

    private val _navigationAction : MutableSharedFlow<MainNavigationAction> = MutableSharedFlow<MainNavigationAction>()
    val navigationAction : SharedFlow<MainNavigationAction> = _navigationAction.asSharedFlow()

    private val _toastMessage : MutableSharedFlow<String> = MutableSharedFlow<String>()
    val toastMessage : SharedFlow<String> = _toastMessage.asSharedFlow()

    val subwayInfoList : StateFlow<List<SubwayInfoEntity>> = searchText.combine(getSubwayInfoListByFlowUseCase()){ str, list ->
        return@combine if(searchText.value.isBlank()) {
            list
        } else
            list.filter { str in it.subwayName }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500L),
        initialValue = emptyList()
    )

    fun fetchSubwayInfoList() = viewModelScope.launch {
        saveAllSubwayListInLocalDBUseCase().onSuccess { result ->
            if(!result){
                _toastMessage.emit(networkErrorMessage)
            }
        }.onFailure {
            _toastMessage.emit(networkErrorMessage)
        }
    }

    override fun toggleSubwayInfoBookMarked(subwayInfoEntity: SubwayInfoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            toggleSubwayInfoBookMarkedUseCase(subwayInfoEntity.copy(isBookmarked = !subwayInfoEntity.isBookmarked))
        }
    }

    override fun navigateToDetail(subwayName: String) {
        viewModelScope.launch {
            _navigationAction.emit(MainNavigationAction.Detail(subwayName))
        }
    }

    override fun navigateToFavorite() {
        viewModelScope.launch {
            _navigationAction.emit(MainNavigationAction.Favorite)
        }
    }
}