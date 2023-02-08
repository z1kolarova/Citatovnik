package com.example.citatovnik.predelane.ulozenecitaty

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.citatovnik.databinding.FragmentUlozeneCitatyBinding
import com.example.citatovnik.predelane.CitatovnikApplication
import com.example.citatovnik.predelane.db.CitatAdapter
import com.example.citatovnik.predelane.db.CitatDBItem

class UlozeneCitatyFragment : Fragment() {

    private lateinit var viewModel: UlozeneCitatyViewModel
    private lateinit var viewModelFactory: UlozeneCitatyViewModelFactory
    private lateinit var binding: FragmentUlozeneCitatyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        viewModelFactory = UlozeneCitatyViewModelFactory((activity?.application as CitatovnikApplication).repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(UlozeneCitatyViewModel::class.java)
        binding = FragmentUlozeneCitatyBinding.inflate(layoutInflater)

        val recycler: RecyclerView = binding.ulozeneCitatyRecyclerView
        viewModel.vsechnyUlozeneCitaty.observe(viewLifecycleOwner, Observer { seznamCitatu ->
            recycler.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = CitatAdapter(seznamCitatu)
                (it.adapter as CitatAdapter).viewModel = viewModel
            }
        })

        viewModel.citat.observe(viewLifecycleOwner, Observer { citat ->
            citat?.let {
                //showLocation(citat)
               // viewModel.ResetLocation()
            }
        })

        binding.ulozeneCitatyViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}