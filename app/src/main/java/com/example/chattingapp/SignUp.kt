package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chattingapp.RegisterActivity
import com.example.chattingapp.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SignUp : AppCompatActivity() {
    private var logInPageIntent:Intent?=null
    private lateinit var auth: FirebaseAuth
//    private var _binding: com.example.chattingapp.databinding.?=null
    override fun onCreate(savedInstanceState: Bundle?) {
    // Initialize Firebase Auth
    auth = Firebase.auth
//        _binding= com.example.chattingapp.databinding.UserSignupPageBinding.inflate(LayoutInflater.from(this))
        logInPageIntent=Intent(this, RegisterActivity::class.java)
//        var binding=_binding!!
        super.onCreate(savedInstanceState)

        setContentView(R.layout.user_signup_page)
        var signInButton=findViewById<Button>(R.id.sign_in_button)

        signInButton.setOnClickListener {
            var gmail=findViewById<TextInputEditText>(R.id.ti_gmail).text.toString()
            var password=findViewById<TextInputEditText>(R.id.ti_password).text.toString()
            auth.createUserWithEmailAndPassword(gmail, password)
                .addOnCompleteListener(this) { task ->
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

}