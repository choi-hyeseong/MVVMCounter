package com.example.mvvmcounter.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmcounter.model.NumberData
import com.example.mvvmcounter.repository.PreferenceRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PreferenceRepository(application.getSharedPreferences("COUNTER", Context.MODE_PRIVATE))
    val numberData : MutableLiveData<NumberData> = repository.loadData() //mutable로 해야 set등 가능


    fun storeData() {
        numberData.value?.let {
            repository.saveData(it)
        }
    }

    fun increase() {
        numberData.value = numberData.value?.apply {
            click += 1
        }
    }

}