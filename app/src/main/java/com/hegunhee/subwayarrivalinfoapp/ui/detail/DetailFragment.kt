package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private val adapter: SubwayArrivalAdapter by lazy {
        SubwayArrivalAdapter(listOf(),
            deleteFavorite = {
                viewModel.deleteFavorites(it)
            },
            insertFavorite = {
                viewModel.insertFavorites(it)
            },
            station_name = args.subwayNm
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        viewModel.initData(args.subwayNm)
        setActionBarTitle()
        observeData()
    }

    private fun setActionBarTitle() {
        (requireActivity() as MainActivity).supportActionBar?.title = args.subwayNm
    }


    private fun observeData() = with(viewModel) {
        stationArrivalList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {

            } else {
                adapter.setData(it)
            }
        }
    }
}