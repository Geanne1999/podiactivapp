package com.example.podiactivapp.ui

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.podiactivapp.databinding.ActivityScannerBinding
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*


class ScannerActivity : AppCompatActivity() {
    val REQUEST_CODE = 200
    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null
    lateinit var videoUri: Uri
    var activSendButton: Boolean = false
    lateinit var progressDialog: ProgressDialog
    private lateinit var binding: ActivityScannerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //to show the capture camera view
        //capturePhotos()

        //to create the videos and show
        doingVideos()
        binding.btnSendVideo.isClickable = activSendButton
        progressDialog= ProgressDialog(this)
        binding.btnSendVideo.setOnClickListener {
            uploadVideo()
        }
    }

    /*fun capturePhotos(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }*/

    private fun doingVideos(){
        val videoIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(videoIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null) {
            val path: String = data.data?.path.toString()
            if (path.contains("/video/")) {
                Log.d(this.javaClass.name, "Video")
                if (mediaControls == null) {
                    // creating an object of media controller class
                    mediaControls = MediaController(this)

                    // set the anchor view for the video view
                    mediaControls!!.setAnchorView(this.binding.scanVideoView)
                }

                // set the media controller for video view
                binding.scanVideoView.setMediaController(mediaControls)
                // set the absolute path of the video file which is going to be played
                val auxUri= data.data
                binding.scanVideoView.setVideoURI(data.data)
                if (auxUri != null) {
                    videoUri = auxUri
                }
                binding.btnSendVideo.isClickable = !activSendButton
                binding.scanVideoView.start()
                Log.d(this.javaClass.name, path)
            } else if (path.contains("/images/")) {
                Log.d(this.javaClass.name, "Image")
            }
        }
    }

    private fun uploadVideo(){
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("videos/$fileName")

        storageReference.putFile(videoUri).
                addOnSuccessListener{
                    binding.scanVideoView.setVideoURI(null)
                    Toast.makeText(this, "Successfuly uploaded", Toast.LENGTH_SHORT).show()
                    if(progressDialog.isShowing) progressDialog.dismiss()
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }.addOnFailureListener{
            if(progressDialog.isShowing) progressDialog.dismiss()
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}