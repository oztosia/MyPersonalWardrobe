package com.example.mypersonalwardrobe.ui.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypersonalwardrobe.firebase.FirebaseSource
import com.google.firebase.auth.FirebaseUser


class AuthViewModel : ViewModel() {


    val firebaseSource: FirebaseSource = FirebaseSource()
    private var userMutableLiveData: MutableLiveData<FirebaseUser>? = firebaseSource!!.getUserMutableLiveData()

    fun login(email: String, password: String) {
        firebaseSource.login(email, password)
        Log.e("TAG", "zarejestrowano" );
    }

   fun register(email: String, password: String){
       firebaseSource.register(email, password)
       Log.e("TAG", "zarejestrowano" );
    }

    fun getUserMutableLiveData(): MutableLiveData<FirebaseUser>? {
        return userMutableLiveData
    }

}