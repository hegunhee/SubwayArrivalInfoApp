package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentMainBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainFragmentViewModel by viewModels()
    private val adapter: SubwayInfoAdpater by lazy {
        SubwayInfoAdpater(listOf(),
            toggleSubwayInfo = {
                viewModel.toggleSubwayInfo(it)
            },
            navigateToDetail = {
                MainFragmentDirections.mainToDetail(it).let { _ ->
                    findNavController().navigate(it)
                }

            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        initObserver()
    }

    private fun initObserver() = with(viewModel) {
        subwayInfoList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                if (editTextLiveData.value == "") {
                    insertSubwayList()
                } else {
                    adapter.setData(it)
                }
            } else {
                adapter.setData(it)
            }
        }
    }
}