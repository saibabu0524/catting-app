package com.example.chattingapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.chattingapp.databinding.MainActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : ComponentActivity() {
    private var _binding: MainActivityBinding? = null
    private lateinit var binding: MainActivityBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = MainActivityBinding.inflate(LayoutInflater.from(this))
        binding = _binding!!
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener {
            fireBaseUserCreation()
        }
    }

    private fun fireBaseUserCreation() {
        val userName = binding.tiUsername.text.toString()
        val email = binding.tiGmail.text.toString()
        val password = binding.tiPassword.text.toString()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("", "createUserWithEmail:success")
                val user = auth.currentUser
            } else {
                // If sign in fails, display a message to the user.
                Log.w("", "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                    baseContext,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
            }

        }
    }

}