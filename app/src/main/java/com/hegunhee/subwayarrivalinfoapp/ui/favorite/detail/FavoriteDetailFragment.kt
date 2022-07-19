package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentFavoriteDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDetailFragment :
    BaseFragment<FragmentFavoriteDetailBinding>(R.layout.fragment_favorite_detail) {

    private val viewModel: FavoriteDetailViewModel by viewModels()
    val args: FavoriteDetailFragmentArgs by navArgs()
    private val adapter : FavoriteDetailAdapter by lazy { FavoriteDetailAdapter(listOf()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        viewModel.getFavoriteSubwayInfo(args.favorites)
        setActionBarTitle()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        subwayInfoList.observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }

    private fun setActionBarTitle() = with(binding) {
        (requireActivity() as MainActivity).supportActionBar?.title = args.favorites.subway_info
    }
}