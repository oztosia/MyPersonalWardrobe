package com.example.mypersonalwardrobe.ui.auth

import android.content.ContentValues
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mypersonalwardrobe.R
import com.example.mypersonalwardrobe.databinding.FragmentSignInBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null

    private lateinit var authViewModel: AuthViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.getUserMutableLiveData()?.observe(this,
            Observer<FirebaseUser?> { firebaseUser ->
                if (firebaseUser != null) {
                    findNavController().navigate(R.id.action_SignInFragment_to_HomeFragment)
                }
            })
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.buttonSignIn.setOnClickListener {
                val email: String = binding.authEmail.text.toString()
                val password: String = binding.authPassword.text.toString()
                if (email.length > 0 && password.length > 6) {
                    authViewModel.login(email, password)
                }
                else{
                    Toast.makeText(
                        context, "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show()
                                }
                    }
            binding.textViewSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_SignInFragment_to_SignUpFragment)
            }
        }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
}

