package com.example.citatovnik.ui.ulozene_citaty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.databinding.FragmentUlozeneCitatyBinding

class UlozeneCitatyFragment : Fragment() {

    private var _binding: FragmentUlozeneCitatyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ulozeneCitatyViewModel =
            ViewModelProvider(this).get(UlozeneCitatyViewModel::class.java)

        _binding = FragmentUlozeneCitatyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        ulozeneCitatyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}