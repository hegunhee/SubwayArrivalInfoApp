package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentFavoriteDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment

class FavoriteDetailFragment :
    BaseFragment<FragmentFavoriteDetailBinding>(R.layout.fragment_favorite_detail) {

    private val viewModel: FavoriteDetailViewModel by viewModels()
    val args: FavoriteDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
        }
        Toast.makeText(requireContext(), args.favorites.toString(), Toast.LENGTH_SHORT).show()
        setActionBarTitle()
    }

    private fun setActionBarTitle() = with(binding) {
        (requireActivity() as MainActivity).supportActionBar?.title = "즐겨찾기"
    }
}