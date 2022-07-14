package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.databinding.FragmentDetailBinding
import com.hegunhee.subwayarrivalinfoapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    val args : DetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("DetailFragment",args.subwayNm)
    }
}