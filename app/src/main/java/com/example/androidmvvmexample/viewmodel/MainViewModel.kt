package com.example.androidmvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmvvmexample.repository.MainRepository

class MainViewModel(
    private val repository: MainRepository
    ): ViewModel() {

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus: LiveData<String> = _loginStatus

//    private val _usrId = MutableLiveData<String>()
//    val usrId: LiveData<String> = _usrId
//
//    private val _usrPw = MutableLiveData<String>()
//    val usrPd: LiveData<String> = _usrPw

//    var usrName: String? = usrPd.toString()
//    var usrPasswd: String? = usrId.toString()

    fun loadResult(usrName: String, usrPasswd: String) {
        Log.d("태그1", "${usrName}, ${usrPasswd}")
        if (usrName != null && usrPasswd != null) {
            val res: String = repository.loadResult(usrName, usrPasswd)
            res?.let { res ->
                _loginStatus.value = res
            }
        }
    }
}