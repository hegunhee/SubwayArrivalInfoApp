package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.domain.DeleteFavoritesUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.GetFavoritesListByFlow
import com.hegunhee.subwayarrivalinfoapp.domain.GetSubwayInfoListByFlowUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.InsertFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesListByFlow: GetFavoritesListByFlow,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase

): ViewModel() {

    val favoriteList : LiveData<List<Favorites>> = getFavoritesListByFlow().asLiveData()


     fun deleteFavorite(station_info : String) = viewModelScope.launch(Dispatchers.IO){
         deleteFavoritesUseCase(station_info)
     }
}