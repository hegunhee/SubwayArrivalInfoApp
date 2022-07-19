package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentFavoriteBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite){

    private val viewModel : FavoriteViewModel by viewModels()
    private val adapter : FavoriteAdapter by lazy { FavoriteAdapter(listOf(),{station_info ->
        viewModel.deleteFavorite(station_info)

    }) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        setActionBarTitle()
        observeData()
    }

    private fun setActionBarTitle(){
        (requireActivity() as MainActivity).supportActionBar?.title = "즐겨찾기"
    }

    private fun observeData() = with(viewModel){
        favoriteList.observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}