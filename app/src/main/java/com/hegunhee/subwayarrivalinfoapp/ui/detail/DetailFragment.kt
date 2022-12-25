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

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var adapter: SubwayArrivalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SubwayArrivalAdapter(emptyList(), actionHandler = viewModel, station_name = args.subwayNm)
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