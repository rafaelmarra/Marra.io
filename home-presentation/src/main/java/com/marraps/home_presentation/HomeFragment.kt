package com.marraps.home_presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.marraps.base.BaseFragment
import com.marraps.home_presentation.databinding.FragmentHomeBinding
import com.marraps.models.affixes.AffixDetails
import com.marraps.utils.makeVisible
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        viewModel.getAffixes()
    }

    private fun initObservers() {
        viewModel.getAffixesState.observe(viewLifecycleOwner, Observer {
            binding.homeLoading.makeVisible(false)

            when (it) {
                is HomeViewModel.GetAffixesState.Loading -> binding.homeLoading.makeVisible()
                is HomeViewModel.GetAffixesState.Success -> initList(it.response.affixDetailsList)
                is HomeViewModel.GetAffixesState.Error -> showError(it.error)
            }
        })
    }

    private fun initList(affixDetailsList: List<AffixDetails>) {
        binding.homeList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = HomeListAdapter(affixDetailsList)
        }
    }

    private fun showError(error: Exception) {
        Toast.makeText(context, error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}