package com.kiroglue.navigationshowcase.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kiroglue.navigationshowcase.data.UserStore
import com.kiroglue.navigationshowcase.databinding.FragmentNotificationsBinding
//With Safe Args
class NotificationsFragment : Fragment() {
	
	private lateinit var notificationsViewModel: NotificationsViewModel
	private var _binding: FragmentNotificationsBinding? = null
	
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		notificationsViewModel =
			ViewModelProvider(this).get(NotificationsViewModel::class.java)
		
		_binding = FragmentNotificationsBinding.inflate(inflater, container, false)
		val root: View = binding.root
		
		val textView: TextView = binding.textNotifications
		notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
			textView.text = it
		})
		return root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.apply {
			btnIncreaseCounter.setOnClickListener {
				increaseCounter()
			}
			btnExample1.setOnClickListener {
				navigateWithoutValue()
			}
			btnExample2.setOnClickListener {
				navigateWithDefaultData()
			}
			btnExample3.setOnClickListener {
				navigateWithOverriddenDefaultData()
			}
			btnExample4.setOnClickListener {
				navigateWithoutDefaultData()
			}
			btnLoginExample1.setOnClickListener {
				navigateToAccountDetail(true)
			}
			
			btnLoginExample2.setOnClickListener {
				navigateToAccountDetail(false)
			}
		}
	}
	
	private fun increaseCounter() {
		notificationsViewModel.increaseCounter()
	}
	
	private fun navigateWithoutValue() {
		findNavController()
			.navigate(NotificationsFragmentDirections
				.actionNotificationToNotificationDetailNoValue())
	}
	//If the destination fragment has a default value, no need to add.
	private fun navigateWithDefaultData() {
		findNavController()
			.navigate(NotificationsFragmentDirections
					.actionNotificationsToNotificationDetail1())
	}
	
	//If the action has argument.
	private fun navigateWithOverriddenDefaultData() {
		findNavController()
			.navigate(NotificationsFragmentDirections
				.actionNotificationsToNotificationDetail1WithArg(1))
	}
	
	
	//If the destination fragment has not default value
	private fun navigateWithoutDefaultData() {
		findNavController()
			.navigate(NotificationsFragmentDirections
				.actionNotificationsToNotificationDetail2(2))
	}
	
	private fun navigateToAccountDetail(doLogin: Boolean) {
		if(doLogin){
			UserStore.login()
		}else{
			UserStore.logout()
		}
		findNavController()
			.navigate(NotificationsFragmentDirections
				.toProfile())
	}
}