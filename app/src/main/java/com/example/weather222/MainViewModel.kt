package com.example.weather222

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather222.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<WeatherModel>()
}