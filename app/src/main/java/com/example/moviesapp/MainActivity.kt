package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var flag_home_frag = true
    var flag_movies_frag = false
    var flag_fave_frag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavView.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.bottom_home_btn -> if (flag_home_frag) {}
                else {
                    if (flag_movies_frag) {
                        findNavController(R.id.fragmentContainerView).navigate(R.id.action_Shows_to_homeFragment)
                        flag_movies_frag = false
                        flag_home_frag = true
                    }

                    else if (flag_fave_frag) {
                        findNavController(R.id.fragmentContainerView).navigate(R.id.action_favoritesFragment_to_homeFragment)
                        flag_fave_frag = false
                        flag_home_frag = true
                    }}

                R.id.bottom_movies_btn -> {
                    if(flag_movies_frag){}
                    else
                    {
                        if(flag_home_frag){
                            findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_Shows)
                            flag_home_frag = false
                            flag_movies_frag = true
                        }
                        else if(flag_fave_frag){
                            findNavController(R.id.fragmentContainerView).navigate(R.id.action_favoritesFragment_to_Shows)
                            flag_fave_frag = false
                            flag_movies_frag = true
                        }
                    }
                }

                R.id.bottom_favorites_btn -> {
                    if(flag_fave_frag){}
                    else
                    {
                        if (flag_home_frag){
                            findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_favoritesFragment)
                            flag_home_frag = false
                            flag_fave_frag = true
                        }
                        else if(flag_movies_frag){
                            findNavController(R.id.fragmentContainerView).navigate(R.id.action_Shows_to_favoritesFragment)
                            flag_movies_frag = false
                            flag_fave_frag = true
                        }
                    }
                }}

            true
        }
    }
}