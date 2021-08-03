package com.kiroglue.navigationshowcase.ui.dashboarddetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiroglue.navigationshowcase.R
import com.kiroglue.navigationshowcase.databinding.FragmentDashboardDetailBinding

class DashboardDetailFragment : Fragment() {
	
	private var _binding: FragmentDashboardDetailBinding? = null
	
	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentDashboardDetailBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		arguments?.getInt(getString(R.string.arg_counter))?.let {
			binding.textDashboard.text = "Dashboard Detail Fragment counter $it"
		}
	}
}