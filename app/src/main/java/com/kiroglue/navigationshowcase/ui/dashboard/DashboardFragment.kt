package com.kiroglue.navigationshowcase.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kiroglue.navigationshowcase.R
import com.kiroglue.navigationshowcase.databinding.FragmentDashboardBinding
//Without Safe Args
class DashboardFragment : Fragment() {
	
	private lateinit var dashboardViewModel: DashboardViewModel
	private var _binding: FragmentDashboardBinding? = null
	
	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		dashboardViewModel =
			ViewModelProvider(this).get(DashboardViewModel::class.java)
		
		_binding = FragmentDashboardBinding.inflate(inflater, container, false)
		val root: View = binding.root
		
		val textView: TextView = binding.textDashboard
		dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
			textView.text = it.toString()
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
				navigateWithDefaultDestinationData()
			}
			btnExample3.setOnClickListener {
				navigateWithOverriddenInActionData()
			}
			btnExample4.setOnClickListener {
				navigateWithOverriddenInBundleData()
			}
		}
	}
	
	private fun increaseCounter() {
		dashboardViewModel.increaseCounter()
	}
	
	private fun navigateWithoutValue() {
		findNavController()
			.navigate(R.id.action_dashboard_to_dashboard_detail_no_value)
	}
	
	private fun navigateWithDefaultDestinationData() {
		findNavController()
			.navigate(R.id.action_dashboard_to_dashboard_detail_with_default_data)
	}
	
	private fun navigateWithOverriddenInActionData() {
		findNavController()
			.navigate(R.id.action_dashboard_to_dashboard_detail_with_overriden_data)
	}
	
	private fun navigateWithOverriddenInBundleData() {
		val bundle = Bundle().apply {
			putInt(getString(R.string.arg_counter),
				dashboardViewModel.counter.value!!)
		}
		
		findNavController()
			.navigate(R.id.action_dashboard_to_dashboard_detail_with_value, bundle)
	}
}