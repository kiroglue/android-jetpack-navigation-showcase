package com.kiroglue.navigationshowcase.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kiroglue.navigationshowcase.R
import com.kiroglue.navigationshowcase.databinding.FragmentProfileBinding
import com.kiroglue.navigationshowcase.model.User
import com.kiroglue.navigationshowcase.ui.login.LoginFragment
import com.kiroglue.navigationshowcase.ui.login.SharedUserViewModel

class ProfileFragment : Fragment() {
	
	private var _binding: FragmentProfileBinding? = null
	private val binding get() = _binding!!
	
	private lateinit var sharedUserViewModel: SharedUserViewModel
	private val safeArgs: ProfileFragmentArgs by navArgs()
	
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		sharedUserViewModel =
			ViewModelProvider(requireActivity()).get(SharedUserViewModel::class.java)
		Log.i("Demo", "Profile Viewmodel hashcode = ${sharedUserViewModel.hashCode()}")
		_binding = FragmentProfileBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		mockUserLoginStatus()
		
		
		sharedUserViewModel.user.observe(viewLifecycleOwner){ user->
			if(user != null){
				//User has already logined
				Log.i("Demo", "Viewmodel user not null")
			}else{
				//User haven't logined yet
				Log.i("Demo", "Viewmodel user null")
				findNavController().navigate(ProfileFragmentDirections.toLogin())
			}
		}
		
		val navController = findNavController()
		val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
			?: throw IllegalStateException()
		savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL)?.observe(viewLifecycleOwner){ success ->
			Log.i("Demo", "Saved state result $success")
			if(!success){
				findNavController().popBackStack(R.id.navigation_profile,true)
			}
		}
	}
	
	private fun mockUserLoginStatus() {
		safeArgs.argIsLogin.also {
			if (it) {
				sharedUserViewModel.user.value = User("Erhan Kıroğlu")
			}
		}
	}
	
	private fun showWelcomeMessage() {
		Log.i("Demo", "Success")
	}
}