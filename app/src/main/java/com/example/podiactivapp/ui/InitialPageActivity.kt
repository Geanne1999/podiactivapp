package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.podiactivapp.R
import com.example.podiactivapp.databinding.ActivityInitialPageBinding
import kotlinx.android.synthetic.main.activity_initial_page.*

class InitialPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInitialPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_initial_page)
        binding = ActivityInitialPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            title = ""
            setDisplayHomeAsUpEnabled(true)
        }
        listeners()
    }
    private fun listeners(){
        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        btnSubscribe.setOnClickListener {
            startActivity(Intent(this, SubscriptionActivity::class.java))
        }
    }
}