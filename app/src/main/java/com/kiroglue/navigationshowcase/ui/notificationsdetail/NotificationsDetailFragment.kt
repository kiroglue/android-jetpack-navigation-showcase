package com.kiroglue.navigationshowcase.ui.notificationsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kiroglue.navigationshowcase.R
import com.kiroglue.navigationshowcase.databinding.FragmentNotificationsBinding
import com.kiroglue.navigationshowcase.databinding.FragmentNotificationsDetailBinding
import com.kiroglue.navigationshowcase.ui.notifications.NotificationsFragmentDirections

//With Safe Args
class NotificationsDetailFragment : Fragment() {
	
	private var _binding: FragmentNotificationsDetailBinding? = null
	
	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!
	private val safeArgs: NotificationsDetailFragmentArgs by navArgs()
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentNotificationsDetailBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		safeArgs.argCounter.also {
			binding.textNotificationDetail.text = "Notification Detail Fragment counter $it"
		}
		
		binding.apply {
			btnNotificationAdd.setOnClickListener {
				navigateToNotificationAdd()
			}
		}
	}
	
	private fun navigateToNotificationAdd() {
		findNavController()
			.navigate(NotificationsDetailFragmentDirections
				.actionNotificationsDetailToNotificationAdd())
	}
}