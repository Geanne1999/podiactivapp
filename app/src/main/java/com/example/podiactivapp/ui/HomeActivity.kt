package com.example.podiactivapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.config_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when(item.itemId){
      R.id.settings -> {
        startActivity(Intent(this, AccountActivity::class.java))
        finish()
      }

    }
    return super.onOptionsItemSelected(item)
  }

  private fun loadFragment(fragment: Fragment){
    val transaction= supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
  }
}