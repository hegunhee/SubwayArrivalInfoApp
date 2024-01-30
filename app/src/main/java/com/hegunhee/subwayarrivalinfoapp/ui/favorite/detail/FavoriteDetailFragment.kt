package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentFavoriteDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
            subwayRecyclerView.adapter = adapter
        }
        viewModel.getFavoriteSubwayInfo(args.favorites)
        setActionBarTitle()
        observeData()
    }

    private fun setActionBarTitle()   {
        (requireActivity() as MainActivity).supportActionBar?.title = args.favorites.subwayInfo
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch{
                    viewModel.subwayInfoListState.collect {
                        when(it){
                            is SubwayInfoListState.Initialized -> {}
                            is SubwayInfoListState.Success -> {
                                adapter.submitList(it.subwayInfoList)
                            }
                            is SubwayInfoListState.Failure -> {
                                Toast.makeText(requireContext(), R.string.networkErrorMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }
}