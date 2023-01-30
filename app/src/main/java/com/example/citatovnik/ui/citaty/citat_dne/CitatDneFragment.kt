package com.example.citatovnik.ui.citaty.citat_dne

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.citatovnik.R

class CitatDneFragment : Fragment() {

    companion object {
        fun newInstance() = CitatDneFragment()
    }

    private lateinit var viewModel: CitatDneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_citat_dne, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CitatDneViewModel::class.java)
        // TODO: Use the ViewModel
    }

}