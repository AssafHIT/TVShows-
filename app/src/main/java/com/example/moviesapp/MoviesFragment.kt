package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.databinding.HomeLayoutBinding
import com.example.moviesapp.databinding.MoviesLayoutBinding

class MoviesFragment:Fragment() {
    private var _binding : MoviesLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MoviesLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        refreshApp()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun refreshApp()
    {
        binding.swipeToRefresh.setOnRefreshListener {
            Toast.makeText(requireActivity(), "Page refreshed", Toast.LENGTH_LONG).show()
            binding.swipeToRefresh.isRefreshing = false
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}