package com.example.mypersonalwardrobe.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mypersonalwardrobe.R
import com.example.mypersonalwardrobe.databinding.BottomSheetItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class GalleryBottomSheet: BottomSheetDialogFragment() {

    private var _binding: BottomSheetItemBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


// TODO: 21.09.2021
//viewmodel here

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.bottom_sheet_item, container, false)

        binding.camera.setOnClickListener {
            findNavController().navigate(R.id.action_homeBottomSheet_to_HomeFragment)
        }

        binding.files.setOnClickListener {
            findNavController().navigate(R.id.action_homeBottomSheet_to_HomeFragment)
            }

        return binding.root
    }


}
