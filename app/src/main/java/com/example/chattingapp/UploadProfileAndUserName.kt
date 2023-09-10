package com.example.chattingapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.chattingapp.R
import com.example.chattingapp.databinding.UploadProfileAndUsernameBinding

class UploadProfileAndUserName:AppCompatActivity() {
    private var image:ImageView?=null
    private var _profileBinding:UploadProfileAndUsernameBinding?=null
    lateinit var profileBinding:UploadProfileAndUsernameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        profileBinding= UploadProfileAndUsernameBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_profile_and_username)
        image = findViewById(R.id.user_profile_image)
        profileBinding.profileAndUsernameSubmitButton.setOnClickListener {
            uploadProfileOptionAlert()
        }
//        button.setOnClickListener {
//            val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            changeImage.launch(intent)
//
//        }
//        cameraAccess.setOnClickListener {
//            val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            captureImage.launch(cameraIntent)
//        }

    }

    private val changeImage =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data = it.data
                val imgUri = data?.data
                image?.setImageURI(imgUri)
            }
        }
    private val captureImage = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val capturedImage: Bitmap = data?.extras?.get("data") as Bitmap
            image?.setImageBitmap(capturedImage)
        }
    }

    private fun uploadProfileOptionAlert() {
        val alert = androidx.appcompat.app.AlertDialog.Builder(this)
        alert.setTitle("Upload Profile")
        alert.setMessage("upload profile by gallery or camera")
        alert.setPositiveButton("Gallery") { _, _ ->
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            changeImage.launch(intent)
        }
        alert.setNegativeButton("Camera") { _, _ ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            captureImage.launch(cameraIntent)
        }
        val deleteItemAlert: androidx.appcompat.app.AlertDialog = alert.create()
        deleteItemAlert.setCancelable(false)
        deleteItemAlert.show()
    }


}
