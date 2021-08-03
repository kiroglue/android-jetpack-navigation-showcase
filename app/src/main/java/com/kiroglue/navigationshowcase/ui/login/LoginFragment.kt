package com.kiroglue.navigationshowcase.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kiroglue.navigationshowcase.databinding.FragmentLoginBinding
import com.kiroglue.navigationshowcase.model.User

//With Safe Args
class LoginFragment : Fragment() {
	
	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!
	
	private var savedStateHandle : SavedStateHandle? = null
	private lateinit var sharedUserViewModel: SharedUserViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		sharedUserViewModel =
			ViewModelProvider(requireActivity()).get(SharedUserViewModel::class.java)
		Log.i("Demo", "Login Viewmodel hashcode = ${sharedUserViewModel.hashCode()}")
		_binding = FragmentLoginBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		savedStateHandle = findNavController().previousBackStackEntry?.savedStateHandle
			?: throw IllegalStateException("the login fragment must not be a start destination")
		savedStateHandle?.set(LOGIN_SUCCESSFUL,false)
		
		binding.apply {
			btnLoginSuccess.setOnClickListener {
				onLoginSuccess()
			}
			btnLoginCancel.setOnClickListener {
				onLoginCanceled()
			}
		}
		

	}
	
	private fun onLoginSuccess() {
		sharedUserViewModel.user.value = User("Erhan Kıroğlu")
		savedStateHandle?.set(LOGIN_SUCCESSFUL, true)
		findNavController().popBackStack()
	}
	
	private fun onLoginCanceled() {
		findNavController().popBackStack()
	}
	
	companion object{
		val LOGIN_SUCCESSFUL = "login_succcessful"
	}
}