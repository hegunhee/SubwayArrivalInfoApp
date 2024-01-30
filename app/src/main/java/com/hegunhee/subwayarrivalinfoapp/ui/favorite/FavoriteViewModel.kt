package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.DeleteFavoritesUseCase
import com.hegunhee.subwayarrivalinfoapp.domain.usecase.GetFavoritesListByFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesListByFlowUseCase: GetFavoritesListByFlowUseCase,
    private val deleteFavoritesUseCase: DeleteFavoritesUseCase
): ViewModel(), FavoriteActionHandler{

    private val _navigationAction : MutableSharedFlow<FavoriteNavigationAction> = MutableSharedFlow()
    val navigationAction : SharedFlow<FavoriteNavigationAction> = _navigationAction.asSharedFlow()

    val favoriteList : Flow<List<Favorites>> = getFavoritesListByFlowUseCase().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500L),
            initialValue = emptyList()
        )

    override fun showDetailFavorite(favorite: Favorites) {
        viewModelScope.launch {
            _navigationAction.emit(FavoriteNavigationAction.Detail(favorite))
        }
    }

    override fun deleteFavorite(stationInfo : String) {
         viewModelScope.launch(Dispatchers.IO){
             deleteFavoritesUseCase(stationInfo)
         }
     }
}