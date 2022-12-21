package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hegunhee.subwayarrivalinfoapp.MainActivity
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentMainBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainFragmentViewModel by viewModels()
    private lateinit var adapter: SubwayInfoAdpater

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SubwayInfoAdpater(arrayListOf(),viewModel)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        initObserver()
        setActionBarTitle()
        setHasOptionsMenu(true)
    }

    private fun setActionBarTitle(){
            (requireActivity() as MainActivity).supportActionBar?.title = "Main"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.favorite -> {
                findNavController().navigate(R.id.main_to_favorite)
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private fun initObserver() = with(viewModel) {
        lifecycleScope.launchWhenStarted {
            launch {
                viewModel.navigateDetail.collect{
                    MainFragmentDirections.mainToDetail(it).let { direction ->
                        findNavController().navigate(direction)
                    }
                }
            }
        }
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