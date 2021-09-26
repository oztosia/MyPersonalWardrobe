package com.example.mypersonalwardrobe.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mypersonalwardrobe.R
import com.example.mypersonalwardrobe.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMyInspirations.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_GalleryFragment)
        }

        binding.buttonMyStylizations.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_GalleryFragment)
        }

        binding.buttonMyProfile.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_MyProfileFragment)
        }
        binding.buttonStylist.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_StylistsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}