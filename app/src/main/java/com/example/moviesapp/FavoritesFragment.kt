package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.databinding.FavoritesLayoutBinding
import com.example.moviesapp.databinding.HomeLayoutBinding

class FavoritesFragment:Fragment() {
    private var _binding : FavoritesLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoritesLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshApp()
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