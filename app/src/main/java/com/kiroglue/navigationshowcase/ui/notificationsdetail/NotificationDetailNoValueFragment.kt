package com.kiroglue.navigationshowcase.ui.notificationsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiroglue.navigationshowcase.databinding.FragmentDashboardDetailBinding
import com.kiroglue.navigationshowcase.databinding.FragmentNotificationsDetailBinding

class NotificationDetailNoValueFragment : Fragment() {
	
	private var _binding: FragmentNotificationsDetailBinding? = null
	
	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!
	
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
			binding.textNotificationDetail.text = "Notification Detail Fragment counter with no value"
	}
}