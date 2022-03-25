package com.example.podiactivapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.uea.transirie.mypay.mycoffee.repository.sqlite.PREF_DATA_NAME
import br.uea.transirie.mypay.mycoffee.repository.sqlite.PREF_PRIMEIRO_USO
import br.uea.transirie.mypay.mycoffee.repository.sqlite.PREF_USER_ID
import com.example.podiactivapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            /*if(id > 0){
                if(primeiroUso) startActivity(Intent(this, PrimeiroUsoSaudacaoActivity::class.java))
                else startActivity(Intent(this, HomeActivity::class.java))
            }else{}*/
            startActivity(Intent(this, InitialPageActivity::class.java))
            finish()
        }, 2000)
    }
}