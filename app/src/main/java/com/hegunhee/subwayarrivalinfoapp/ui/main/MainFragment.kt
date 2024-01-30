package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentMainBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import com.hegunhee.subwayarrivalinfoapp.ui.common.subway.SubwayInfoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainFragmentViewModel by viewModels()
    private lateinit var adapter: SubwayInfoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SubwayInfoAdapter(viewModel)
        binding.apply {
            viewmodel = viewModel
            subwayRecyclerView.adapter = adapter
        }
        observeData()
        setActionBarTitle()
    }

    private fun setActionBarTitle() {
        (requireActivity() as MainActivity).supportActionBar?.title = "Main"
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.navigationAction.collect{
                        when(it) {
                            is MainNavigationAction.Detail -> {
                                MainFragmentDirections.mainToDetail(it.subwayName).let { direction ->
                                    findNavController().navigate(direction)
                                }
                            }
                            MainNavigationAction.Favorite -> {
                                findNavController().navigate(R.id.main_to_favorite)
                            }
                        }
                    }
                }
                launch {
                    viewModel.subwayInfoList.collect {
                        if(it.isEmpty() && viewModel.searchText.value.isBlank()){
                            viewModel.fetchSubwayInfoList()
                        }else{
                            adapter.submitList(it)
                        }
                    }
                }
                launch{
                    viewModel.toastMessage.collect{ message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}