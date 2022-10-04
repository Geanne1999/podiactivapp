package com.example.podiactivapp.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import com.example.podiactivapp.R
import com.example.podiactivapp.databinding.ActivityScannerBinding
import kotlinx.android.synthetic.main.activity_scanner.*
import org.jetbrains.anko.startActivityForResult

class ScannerActivity : AppCompatActivity() {
    val REQUEST_CODE = 200
    private lateinit var binding: ActivityScannerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

        capturePhotos()
    }

    fun capturePhotos(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data!=null){
            binding.imgViewCamera.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }
}