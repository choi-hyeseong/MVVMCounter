package com.example.mvvmcounter.repository

import androidx.lifecycle.LiveData
import com.example.mvvmcounter.model.NumberData

interface NumberRepository {

    fun loadData() : LiveData<NumberData>

    fun saveData(data: NumberData)
}