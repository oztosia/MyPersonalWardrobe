package com.example.mypersonalwardrobe.ui.stylists


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mypersonalwardrobe.R
import com.example.mypersonalwardrobe.databinding.FragmentStylistsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class StylistsFragment: Fragment() {

    private var _binding: FragmentStylistsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStylistsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOK.setOnClickListener {
            findNavController().navigate(R.id.action_StylistsFragment_to_HomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}