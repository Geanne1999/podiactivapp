package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.podiactivapp.R
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        supportActionBar?.apply {
            title="Podiactiv"
            setDisplayHomeAsUpEnabled(true)
        }

        constraintLayoutProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
        constraintLayoutMesurePrix.setOnClickListener {
            startActivity(Intent(this, MesureConfigActivity::class.java ))
            finish()
        }
        constraintLayoutInfo.setOnClickListener {
            startActivity(Intent(this, HelpActivity::class.java))
            finish()
        }
        constraintLayoutAboutUs.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java ))
            finish()
        }
        constraintLayoutLogOut.setOnClickListener {
            finishAffinity()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
        return true
    }
}