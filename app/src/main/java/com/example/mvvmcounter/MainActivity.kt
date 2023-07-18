package com.example.mvvmcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcounter.databinding.ActivityMainBinding
import com.example.mvvmcounter.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = MainViewModel(application).apply {
            numberData.observe(this@MainActivity) { //요렇게 하면됨
                binding.textView.text = it.click.toString()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.viewModel?.storeData() //lateinit 오류?
    }
}