package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentMainBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel : MainFragmentViewModel by viewModels()
    private val adapter : SubwayInfoAdpater by lazy {
        SubwayInfoAdpater(listOf())
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            recyclerView.adapter = adapter
        }
        initObserver()
    }

    private fun initObserver() = with(viewModel){
        subwayInfoList.observe(viewLifecycleOwner){
            if(it.isEmpty()){
                if(editTextLiveData.value == ""){
                    Log.d("InsertTest","IsEmpty real ")
                    insertSubwayList()
                }else{
                    adapter.setData(it)
                    Log.d("InsertTest","IsEmpty but search is okay")
                }
            }else{
                adapter.setData(it)
                Log.d("InsertTest",it.toString())
            }
        }
    }
}