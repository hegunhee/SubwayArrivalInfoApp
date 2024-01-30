package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentFavoriteBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {

    private val viewModel: FavoriteViewModel by viewModels()
    private lateinit var adapter: FavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteAdapter(viewModel)
        binding.apply {
            viewmodel = viewModel
            favoriteRecyclerView.adapter = adapter
        }
        setActionBarTitle()
        observeData()
    }

    private fun setActionBarTitle() {
        (requireActivity() as MainActivity).supportActionBar?.title = "즐겨찾기"
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.favoriteList.collect {
                        adapter.submitList(it)
                    }
                }
                launch {
                    viewModel.navigationAction.collect {
                        when(it) {
                            is FavoriteNavigationAction.Detail -> {
                                FavoriteFragmentDirections.favoriteToFavoriteDetail(favorites = it.favorite).let { direction ->
                                    findNavController().navigate(direction)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}