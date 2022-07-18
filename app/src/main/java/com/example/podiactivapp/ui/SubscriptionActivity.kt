package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.podiactivapp.R
import com.example.podiactivapp.databinding.ActivitySubscriptionBinding
import kotlinx.android.synthetic.main.activity_subscription.*

class SubscriptionActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySubscriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title="Subscription"
            setDisplayHomeAsUpEnabled(true)
        }

        btnSubscriptionSave.setOnClickListener {
            Toast.makeText(this, "Compte enregistré!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, InitialPageActivity::class.java))
            finish()
        }
    }
}