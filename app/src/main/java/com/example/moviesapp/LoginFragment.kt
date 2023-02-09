package com.example.moviesapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.databinding.HomeLayoutBinding
import com.example.moviesapp.databinding.LoginLayoutBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment:Fragment() {
    private var _binding : LoginLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginLayoutBinding.inflate(layoutInflater, container, false)
        binding.goToSignUpButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginButton.setOnClickListener {
            val email = binding.loginEmail.getText().toString()
            val password = binding.loginPassword.getText().toString()


            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
//                        val intent = Intent(this, MainActivity::class.java)
//                        startActivity(intent)
                        findNavController().navigate(R.id.action_loginFragment_to_Shows)

                    } else {
                        makeText(requireActivity(), it.exception!!.message.toString(), LENGTH_SHORT).show()
                        Log.i("firbase",it.exception.toString())
                    }
                }
            } else {
                makeText(requireActivity(), "Empty Fields Are not Allowed", LENGTH_SHORT).show()
            }
        }

//        binding.loginRedirectText.setOnClickListener()
//        {
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
//        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//
//    binding = ActivityLoginBinding.inflate(layoutInflater)
//    setContentView(binding.root)
//
//    firebaseAuth = FirebaseAuth.getInstance()
//
//    binding.loginButton.setOnClickListener {
//        val email = binding.loginEmail.getText().toString()
//        val password = binding.loginPassword.getText().toString()
//
//
//        if (email.isNotEmpty() && password.isNotEmpty()) {
//            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(this, it.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
//                    Log.i("firbase",it.exception.toString())
//                }
//            }
//        } else {
//            Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    binding.loginRedirectText.setOnClickListener()
//    {
//        val intent = Intent(this, SignUpActivity::class.java)
//        startActivity(intent)
//    }
//
//}
//
