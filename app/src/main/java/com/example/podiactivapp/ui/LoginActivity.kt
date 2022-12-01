package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.podiactivapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initializing firebase object
        auth = FirebaseAuth.getInstance()

        supportActionBar?.apply {
            title = "Login"
            setDisplayHomeAsUpEnabled(true)
        }

        login_btnEntrar.setOnClickListener {
            login()
        }
        txtEsquecerSenha.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    fun login(){
        val email=binding.logintxtEmail.text.toString()
        val password=binding.logintxtSenha.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
            goToRegister()
        }
    }

    fun goToRegister(){
        val intent= Intent(this,SubscriptionActivity::class.java)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, InitialPageActivity::class.java))
        finish()
        return true
    }
}