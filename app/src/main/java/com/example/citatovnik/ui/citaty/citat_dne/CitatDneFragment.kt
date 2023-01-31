package com.example.citatovnik.ui.citaty.citat_dne

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.citatovnik.R
import com.example.citatovnik.data.Citat
import com.example.citatovnik.data.network.CitatyDataSourceImpl
import com.example.citatovnik.data.network.ConnectivityInterceptorImpl
import com.example.citatovnik.data.network.ZenQuotesAPIService
import com.example.citatovnik.databinding.FragmentCitatDneBinding
import com.example.citatovnik.ui.base.ScopedFragment
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.lazy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CitatDneFragment : ScopedFragment(), KodeinAware {

    override val kodein by Kodein.lazy {  }

    private var viewModelFactory: CitatDneViewModelFactory by instance()






    private lateinit var binding: FragmentCitatDneBinding


    private lateinit var viewModel: CitatDneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_citat_dne, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding = FragmentCitatDneBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CitatDneViewModel::class.java)

/*
        val apiService = ZenQuotesAPIService(ConnectivityInterceptorImpl(this.requireContext()))
        val citatyDataSource = CitatyDataSourceImpl(apiService)

        citatyDataSource.downloadedCitatDne.observe(viewLifecycleOwner, Observer {
            binding.tvCitatDne.text = Citat(it.zneniCitatu, it.autor).toString()
        })

        GlobalScope.launch (Dispatchers.Main) {
            //val citatDneResponse = apiService.vratCitat("today").await()

            //val prvni = citatDneResponse.first()
            //binding.tvCitatDne.text = Citat(prvni.zneniCitatu, prvni.autor).toString()
            citatyDataSource.dotahniCitatDne()
        }
 */
    }
    private fun bindUI() = launch{
        val citatDne = viewModel.citat.await()
        citatDne.observe(this@CitatDneFragment, Observer {
            if (it == null) return@Observer

            binding.tvCitatDne.text = Citat(it.zneniCitatu, it.autor).toString()
        })
    }
}