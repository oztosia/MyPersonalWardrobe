package com.example.mypersonalwardrobe.firebase

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import com.google.firebase.database.FirebaseDatabase
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mypersonalwardrobe.MyPersonalWardrobe
import java.util.*


class FirebaseSource {

    val application = MyPersonalWardrobe.getAppContext()
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    var _userMutableLiveData = MutableLiveData<FirebaseUser>()
    val _signedOutMutableLiveData = MutableLiveData<Boolean>()

    /* val userRole =
         FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserUID)
             .child("Role");

     */

/*     if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOutLiveData.postValue(false);
            /
 */

    fun register(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful){
                    _userMutableLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Toast.makeText(
                        application.getApplicationContext(),
                        "Registration Failure: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    fun login(email: String, password: String) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful){
                    _userMutableLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Toast.makeText(
                        application.getApplicationContext(),
                        "Login Failure: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    @JvmName("getUserMutableLiveData1")
    fun getUserMutableLiveData(): MutableLiveData<FirebaseUser>? {
        if (firebaseAuth!!.currentUser != null) {
            _userMutableLiveData.postValue(firebaseAuth!!.currentUser)
            _signedOutMutableLiveData.postValue(false)
        }
        return _userMutableLiveData
    }

    @JvmName("getSignedOutMutableLiveData1")
    fun getSignedOutMutableLiveData(): MutableLiveData<Boolean>? {
        return _signedOutMutableLiveData
    }


    fun signOut() {
        return firebaseAuth.signOut()
        _signedOutMutableLiveData.postValue(true)
    }

}


