package com.example.podiactivapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.podiactivapp.databinding.ActivityForgotPasswordBinding
import com.example.podiactivapp.ui.LoginActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity()
{
  private lateinit var binding: ActivityForgotPasswordBinding
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    binding=ActivityForgotPasswordBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.apply {
      title="Récuperer mot de passe"
      setDisplayHomeAsUpEnabled(true)
    }

    btnForgotPasswordEnvoyer.setOnClickListener{
      Toast.makeText(this, "Email a été envoyé!", Toast.LENGTH_SHORT).show()
      startActivity(Intent(this, LoginActivity::class.java))
      finish()
    }

  }
}