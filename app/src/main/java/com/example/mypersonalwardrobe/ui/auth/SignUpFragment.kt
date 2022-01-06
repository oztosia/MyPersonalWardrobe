package com.example.mypersonalwardrobe.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mypersonalwardrobe.R
import com.example.mypersonalwardrobe.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {


    lateinit var signUpViewModel: AuthViewModel
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        signUpViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        activity?.let {
            signUpViewModel.getUserMutableLiveData()?.observe(
                it,
                { firebaseUser ->
                    if (firebaseUser != null) {
                        findNavController().navigate(R.id.action_SignUpFragment_to_HomeFragment)
                    }
                })
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_SignUpFragment_to_SignInFragment)
        }

        binding.buttonSignUp.setOnClickListener {
           val email: String = binding.authEmail.text.toString()
            val password: String = binding.authPassword.text.toString();
            if (email.length > 0 && password.length > 6) {
                signUpViewModel.register(email, password)
                //findNavController().navigate(R.id.action_SignUpFragment_to_HomeFragment)
            } else {
                Toast.makeText(
                    context,
                    "Email Address and Password Must Be Entered",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
