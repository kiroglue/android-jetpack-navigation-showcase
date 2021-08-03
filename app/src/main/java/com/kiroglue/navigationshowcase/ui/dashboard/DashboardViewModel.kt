package com.kiroglue.navigationshowcase.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class DashboardViewModel : ViewModel() {
	
	val counter = MutableLiveData(0)
	
	private val _text = counter.map {
		 "Dashboard Fragment counter $it"
	}
	val text: LiveData<String> = _text
	
	fun increaseCounter() {
		counter.value = counter.value!! + 1
	}
}