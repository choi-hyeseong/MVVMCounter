package com.example.mvvmcounter.repository

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmcounter.model.NumberData

class PreferenceRepository(private val preference : SharedPreferences) : NumberRepository {

    //실질적으로 preference 또한 DAO의 형태로 분리하면 좋을듯.

    override fun loadData(): MutableLiveData<NumberData> {
        val result = NumberData(preference.getInt("CLICK", 0))
        return MutableLiveData(result) //??????????????????? 왜 NumberData따로 빼니까 잘되냐

    }

    override fun saveData(data : NumberData) {
        preference.edit().putInt("CLICK", data.click).commit()
    }
}