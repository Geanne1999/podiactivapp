package com.example.podiactivapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.podiactivapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity()
{
  lateinit var bottomNavigationView: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    loadFragment(HomeFragment())
    bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
    bottomNavigationView.setOnItemSelectedListener { item ->
      when (item.itemId) {
        R.id.home -> {
          loadFragment(HomeFragment())
          true
        }
        R.id.album -> {
          loadFragment(AlbumFragment())
          true
        }
        R.id.shopBag -> {
          loadFragment(PanierFragment())
          true
        }
        else -> false
      }
    }
  }

  private fun loadFragment(fragment: Fragment){
    val transaction= supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
  }
}