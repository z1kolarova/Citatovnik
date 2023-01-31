package com.example.citatovnik.predelane.citatdne

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.citatovnik.databinding.FragmentCitatDneBinding
import com.example.citatovnik.predelane.CitatovnikApplication

class CitatDneFragment : Fragment() {

    private lateinit var viewModel: CitatDneViewModel
    private lateinit var viewModelFactory: CitatDneViewModelFactory
    private lateinit var binding: FragmentCitatDneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        viewModelFactory = CitatDneViewModelFactory((activity?.application as CitatovnikApplication).repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CitatDneViewModel::class.java)
        binding = FragmentCitatDneBinding.inflate(layoutInflater)
/*
        val recycler: RecyclerView = binding.historyRecyclerView
        viewModel.wholeHistory.observe(viewLifecycleOwner, Observer { listOfLocDb ->
            recycler.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = LocationAdapter(listOfLocDb)
                (it.adapter as LocationAdapter).viewModel = viewModel
            }
        })

        viewModel.location.observe(viewLifecycleOwner, Observer { loc ->
            loc?.let {
                showLocation(loc)
                viewModel.ResetLocation()
            }
        })

        binding.historyViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    private fun showLocation(location: Location) {
        val action = HistoryFragmentDirections.actionHistoryFragmentToResultFragment(location)
        NavHostFragment.findNavController(this).navigate(action) */
        return binding.root
    }

}