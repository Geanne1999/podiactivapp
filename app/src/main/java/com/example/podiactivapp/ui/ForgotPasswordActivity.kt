package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.podiactivapp.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity()
{
  private lateinit var binding: ActivityForgotPasswordBinding
  private lateinit var mAuth: FirebaseAuth
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    binding=ActivityForgotPasswordBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.apply {
      title="Récuperer mot de passe"
      setDisplayHomeAsUpEnabled(true)
    }

    btnForgotPasswordEnvoyer.setOnClickListener {
      sendEmailResetPassword(edtTextForgotPasswordTxtEmailRecupPassword.text.toString())
    }

  }

  private fun sendEmailResetPassword(email: String){
    mAuth = FirebaseAuth.getInstance()

    mAuth.sendPasswordResetEmail(email).addOnCompleteListener {task ->
      if(task.isSuccessful){
        Toast.makeText(this, "Email a été envoyé!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
      } else{
        Toast.makeText(this, "Email n'a pas pu été envoyé, réssayer plus tard!", Toast.LENGTH_SHORT).show()
      }
    }
  }
}