package com.example.citatovnik.predelane.citatdne

import android.content.Context
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.citatovnik.databinding.FragmentCitatDneBinding
import com.example.citatovnik.predelane.CitatovnikApplication
import com.example.citatovnik.puvodni.data.network.ZenQuotesAPIService
import com.google.android.material.snackbar.Snackbar

class CitatDneFragment : Fragment() {

    private lateinit var viewModel: CitatDneViewModel
    private lateinit var viewModelFactory: CitatDneViewModelFactory
    private lateinit var binding: FragmentCitatDneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        viewModelFactory = CitatDneViewModelFactory((activity?.application as CitatovnikApplication).repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CitatDneViewModel::class.java)
        binding = FragmentCitatDneBinding.inflate(layoutInflater)

        binding.btnUlozitCitatDne.setOnClickListener{
            //viewModel.dotahniCitatDne(requireContext(), it)
        }
/*
        binding.btnGetMyIP.setOnClickListener {
            viewModel.dotahniCitatDne(requireContext(), it)
        }
        binding.btnLocateIP.setOnClickListener {
            viewModel.onLocateClicked(requireContext(), it)
        }

        viewModel.error.observe(viewLifecycleOwner, Observer { msg ->
            if (msg != "") {
                this.view?.let {
                    showMessage(msg, it)
                    viewModel.errorReaded()
                }
            }
        })

        binding.btnHistory.setOnClickListener {
            val action = SetipFragmentDirections.actionSetipFragmentToHistoryFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        viewModel.localized.observe(viewLifecycleOwner, Observer { localized ->
            if( localized ) {
                showLocation(viewModel.location.value as Location)
                viewModel.resetLocation()
            }
        })

        binding.citatDneViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
*/
        return binding.root
    }
/*
    private fun showLocation(location: Location) {
        val action = SetipFragmentDirections.actionSetipFragmentToResultFragment(location)
        NavHostFragment.findNavController(this).navigate(action)
    }
*/
    private fun showMessage(msg: String, view: View ){
        val message = Snackbar.make( view, msg, Snackbar.LENGTH_LONG)
        message.setTextColor(Color.RED)
        message.show()
    }

}