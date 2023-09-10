package com.example.chattingapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.chattingapp.databinding.OtpValidatinBinding
import java.util.Objects

class OtpValidationPage:AppCompatActivity() {
    private lateinit var _binding:OtpValidatinBinding
    private var otpTextField:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=OtpValidatinBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding.root)
        otpTextField=_binding.etOtp

        otpTextField?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Checking","$p1"+"$p2"+"$p3")
                when (otpTextField?.text.toString().length) {
                    5 -> {
                        otpTextField?.removeTextChangedListener(this)
                        otpTextField?.setText("")
                        otpTextField?.addTextChangedListener(this)
                        otpTextField?.setSelection(otpTextField?.text.toString().length)
                        otpTextField?.requestFocus()
                    }
//                    3 -> {
//                        otpTextField?.removeTextChangedListener(this)
//                        otpTextField?.setText(otpTextField?.text.toString()+" ")
//                        otpTextField?.addTextChangedListener(this)
//                        otpTextField?.setSelection(otpTextField?.text.toString().length)
//                        otpTextField?.requestFocus()
//                    }
//                    5 -> {
//                        otpTextField?.removeTextChangedListener(this)
//                        otpTextField?.setText(otpTextField?.text.toString()+"  ")
//                        otpTextField?.addTextChangedListener(this)
//                        otpTextField?.setSelection(otpTextField?.text.toString().length)
//                        otpTextField?.requestFocus()
//                    }
//                    8 -> {
//                        otpTextField?.removeTextChangedListener(this)
//                        otpTextField?.setText(otpTextField?.text.toString()+" ")
//                        otpTextField?.addTextChangedListener(this)
//                        otpTextField?.setSelection(otpTextField?.text.toString().length)
//                        otpTextField?.requestFocus()
//                    }
//                    10 -> {
//                        otpTextField?.removeTextChangedListener(this)
//                        otpTextField?.setText(otpTextField?.text.toString()+" ")
//                        otpTextField?.addTextChangedListener(this)
//                        otpTextField?.setSelection(otpTextField?.text.toString().length)
//                        otpTextField?.requestFocus()
//                    }
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Checking","The inputonTextChange")
            }

            override fun afterTextChanged(p0: Editable?) {
                when (otpTextField?.text.toString().length) {
                    1 -> {
                        otpTextField?.removeTextChangedListener(this)
                        otpTextField?.setText(otpTextField?.text.toString()+" ")
                        otpTextField?.addTextChangedListener(this)
                        otpTextField?.setSelection(otpTextField?.text.toString().length)
                        otpTextField?.requestFocus()
                    }
                    3 -> {
                        otpTextField?.removeTextChangedListener(this)
                        otpTextField?.setText(otpTextField?.text.toString()+" ")
                        otpTextField?.addTextChangedListener(this)
                        otpTextField?.setSelection(otpTextField?.text.toString().length)
                        otpTextField?.requestFocus()
                    }
                    5 -> {
                        otpTextField?.removeTextChangedListener(this)
                        otpTextField?.setText(otpTextField?.text.toString()+"  ")
                        otpTextField?.addTextChangedListener(this)
                        otpTextField?.setSelection(otpTextField?.text.toString().length)
                        otpTextField?.requestFocus()
                    }
                    8 -> {
                        otpTextField?.removeTextChangedListener(this)
                        otpTextField?.setText(otpTextField?.text.toString()+" ")
                        otpTextField?.addTextChangedListener(this)
                        otpTextField?.setSelection(otpTextField?.text.toString().length)
                        otpTextField?.requestFocus()
                    }
                    10 -> {
                        otpTextField?.removeTextChangedListener(this)
                        otpTextField?.setText(otpTextField?.text.toString()+" ")
                        otpTextField?.addTextChangedListener(this)
                        otpTextField?.setSelection(otpTextField?.text.toString().length)
                        otpTextField?.requestFocus()
                    }
                }

            }
        })
    }


}