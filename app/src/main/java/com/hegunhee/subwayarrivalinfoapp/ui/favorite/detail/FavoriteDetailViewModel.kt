package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.domain.GetFavoriteSubwayInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteDetailViewModel @Inject constructor(
    private val getFavoriteSubwayInfoUseCase: GetFavoriteSubwayInfoUseCase
) : ViewModel() {

    private var _subwayInfoListState: MutableStateFlow<SubwayInfoListState> = MutableStateFlow(SubwayInfoListState.Initialized)
    val subwayInfoListState : StateFlow<SubwayInfoListState> = _subwayInfoListState.asStateFlow()



    fun getFavoriteSubwayInfo(favorites: Favorites) = viewModelScope.launch(Dispatchers.IO) {
        getFavoriteSubwayInfoUseCase(favorites).onSuccess {
            _subwayInfoListState.emit(SubwayInfoListState.Success(it))
        }.onFailure {
            _subwayInfoListState.emit(SubwayInfoListState.Failure)
        }
    }
}