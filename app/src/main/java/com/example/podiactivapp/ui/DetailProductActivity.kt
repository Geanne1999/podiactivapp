package com.example.podiactivapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.podiactivapp.R
import com.squareup.picasso.Picasso

class DetailProductActivity : AppCompatActivity() {
    private lateinit var imageViewDetailProduct: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val imageUrl: String = intent.getStringExtra("photoFeet").toString()

        imageViewDetailProduct = findViewById(R.id.imageViewDetailProduct)

        Picasso.get().load(imageUrl).into(imageViewDetailProduct)
        //Changer le nom de l`ecran a partir du nom sauvegarder dans la base des donnees
        supportActionBar?.apply {
            title="Modèle 3D"
            setDisplayHomeAsUpEnabled(true)
        }

        val tailles = resources.getStringArray(R.array.Tailles)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, tailles)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@DetailProductActivity,
                        getString(R.string.selected_item) + " " +
                                "" + tailles[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        finish()
    }
}