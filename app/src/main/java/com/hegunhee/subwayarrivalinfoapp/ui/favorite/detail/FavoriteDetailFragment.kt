package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentFavoriteDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FavoriteDetailFragment :
    BaseFragment<FragmentFavoriteDetailBinding>(R.layout.fragment_favorite_detail) {

    private val viewModel: FavoriteDetailViewModel by viewModels()
    private val args: FavoriteDetailFragmentArgs by navArgs()
    private lateinit var adapter : FavoriteDetailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteDetailAdapter()
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        viewModel.getFavoriteSubwayInfo(args.favorites)
        setActionBarTitle()
        observeData()
    }

    private fun observeData() = with(viewModel) {
        lifecycleScope.launchWhenStarted {
            subwayInfoList.collect {
                adapter.submitList(it)
            }
        }
    }

    private fun setActionBarTitle()   {
        (requireActivity() as MainActivity).supportActionBar?.title = args.favorites.subway_info
    }
}