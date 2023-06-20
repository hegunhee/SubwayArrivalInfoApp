package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.domain.DeleteFavoritesUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.GetFavoritesListByFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesListByFlowUseCase: GetFavoritesListByFlowUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase
): ViewModel(), FavoriteFragmentActionHandler{

    val favoriteList : Flow<List<Favorites>> = getFavoritesListByFlowUseCase()

    private val _navigateToDetailFavorite : MutableSharedFlow<Favorites> = MutableSharedFlow<Favorites>()
    val navigateToDetailFavorite : SharedFlow<Favorites> = _navigateToDetailFavorite.asSharedFlow()


    override fun showDetailFavorite(favorite: Favorites) {
        viewModelScope.launch {
            _navigateToDetailFavorite.emit(favorite)
        }
    }


    override fun deleteFavorite(stationInfo : String) {
         viewModelScope.launch(Dispatchers.IO){
             deleteFavoritesUseCase(stationInfo)
         }
     }
}