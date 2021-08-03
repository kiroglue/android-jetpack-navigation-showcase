package com.kiroglue.navigationshowcase.ui.notificationadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kiroglue.navigationshowcase.R
import com.kiroglue.navigationshowcase.databinding.FragmentNotificationsAddBinding

//With Safe Args
class NotificationAddFragment : Fragment() {
	
	private var _binding: FragmentNotificationsAddBinding? = null
	
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentNotificationsAddBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.apply {
			btnBackToNotifications.setOnClickListener {
				popupToNotifications()
			}
			btnBackToNotificationsClearBackstack.setOnClickListener {
				popupToNotificationsInclusive()
			}
			btnGlobalAction.setOnClickListener {
				navigateWithGlobalAction()
			}
			btnGlobalAction2.setOnClickListener {
				navigateWithGlobalActionClearBackStack()
			}
		}
	}
	
	private fun popupToNotifications() {
		findNavController()
			.navigate(
				NotificationAddFragmentDirections
					.actionNotificationAddPopupToNotification()
			)
	}
	
	private fun popupToNotificationsInclusive() {
		findNavController()
			.navigate(
				NotificationAddFragmentDirections
					.actionNotificationAddPopupToNotificationInclusive()
			)
	}
	
	private fun navigateWithGlobalAction() {
		findNavController().navigate(R.id.action_global_home)
	}
	
	private fun navigateWithGlobalActionClearBackStack() {
		findNavController().navigate(R.id.action_global_home_clear_back_stack)
	}
	
	
}