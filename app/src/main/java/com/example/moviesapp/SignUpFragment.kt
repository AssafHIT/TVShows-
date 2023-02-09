package com.example.moviesapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.databinding.SignUpLayoutBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment:Fragment() {
    private var _binding : SignUpLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = SignUpLayoutBinding.inflate(layoutInflater, container, false)



        binding.goToLoginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener {
            val email = binding.signupEmail.getText().toString()
            val password = binding.signupPassword.getText().toString()
            val password2= binding.signupPassword2.getText().toString()

        if (email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()) {


            if (password == password2) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                    } else {
                        Toast.makeText(requireActivity(), it.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else {
                Toast.makeText(requireActivity(),"Password is not matching", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(requireActivity(),"Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
        }
    }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }}
