package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.podiactivapp.R
import com.example.podiactivapp.databinding.ActivitySubscriptionBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_subscription.*

class SubscriptionActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySubscriptionBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initializing firebase object
        auth = FirebaseAuth.getInstance()

        supportActionBar?.apply {
            title="Subscription"
            setDisplayHomeAsUpEnabled(true)
        }

        btnSubscriptionSave.setOnClickListener {
            register()
        }
    }

    fun register(){
        val email=binding.txtSubscriptionEmail.text.toString()
        val password=binding.txtSubscriptionNewPassword.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent= Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, InitialPageActivity::class.java))
        finish()
        return true
    }
}