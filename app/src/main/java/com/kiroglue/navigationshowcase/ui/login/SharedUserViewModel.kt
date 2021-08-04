package com.kiroglue.navigationshowcase.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kiroglue.navigationshowcase.data.UserStore
import com.kiroglue.navigationshowcase.model.User

class SharedUserViewModel : ViewModel() {
	
	var isLogin = MutableLiveData(UserStore.isLogin())
	
	fun checkLogin (){
		isLogin.value = UserStore.isLogin()
	}
}