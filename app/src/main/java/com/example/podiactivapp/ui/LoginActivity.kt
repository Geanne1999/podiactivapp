package com.example.podiactivapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.podiactivapp.R
import com.example.podiactivapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Login"
            setDisplayHomeAsUpEnabled(true)
        }

        login_btnEntrar.setOnClickListener {
            Toast.makeText(this, "In implementation!", Toast.LENGTH_SHORT).show()
        }
    }
}