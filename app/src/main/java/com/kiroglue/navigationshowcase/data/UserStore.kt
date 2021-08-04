package com.kiroglue.navigationshowcase.data

import com.kiroglue.navigationshowcase.model.User

object UserStore {
	var user: User? = null
	private set
	
	fun isLogin() = user != null
	
	fun login() {
		user = User("Erhan Kıroğlu")
	}
	
	fun logout(){
		user = null
	}
}