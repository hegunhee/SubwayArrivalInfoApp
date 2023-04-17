package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var adapter: SubwayArrivalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SubwayArrivalAdapter(actionHandler = viewModel, station_name = args.subwayNm)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        viewModel.fetchSubwayArrivalInfo(args.subwayNm)
        setActionBarTitle()
        observeData()
    }

    private fun setActionBarTitle() {
        (requireActivity() as MainActivity).supportActionBar?.title = args.subwayNm
    }


    private fun observeData() = with(viewModel) {
        lifecycleScope.launchWhenStarted {
            launch {
                stationArrivalListState.collect {
                    when(it){
                        is SubwayArrivalListState.Initialized -> {}
                        is SubwayArrivalListState.Success -> {
                            adapter.submitList(it.subwayInfoList)
                        }
                        is SubwayArrivalListState.Failure ->{
                            Toast.makeText(requireContext(), R.string.networkErrorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }
}