package com.kiroglue.navigationshowcase.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kiroglue.navigationshowcase.model.User

class SharedUserViewModel : ViewModel() {
	
	var user = MutableLiveData<User?>(null)
	
}