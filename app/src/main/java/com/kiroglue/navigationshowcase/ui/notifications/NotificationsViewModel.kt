package com.kiroglue.navigationshowcase.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class NotificationsViewModel : ViewModel() {
	
	val counter = MutableLiveData(0)
	
	private val _text = counter.map {
		"Notification Fragment counter $it"
	}
	val text: LiveData<String> = _text
	
	fun increaseCounter() {
		counter.value = counter.value!! + 1
	}
}