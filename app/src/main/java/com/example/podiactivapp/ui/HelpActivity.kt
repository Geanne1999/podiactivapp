package com.example.podiactivapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.podiactivapp.R

class HelpActivity : AppCompatActivity() {
    lateinit var frequentQuestionsLV: ListView
    lateinit var listAdapter: ArrayAdapter<String>
    lateinit var frequentQuestionsList: ArrayList<String>
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        supportActionBar?.apply {
            title="Modèle 3D"
            setDisplayHomeAsUpEnabled(true)
        }

        // initializing variables of list view with their ids.
        frequentQuestionsLV = findViewById(R.id.idLVFrequentQuestions)
        searchView = findViewById(R.id.idSVFrequentQuestions)

        // initializing list and adding data to list
        frequentQuestionsList = ArrayList()
        frequentQuestionsList.add("C")
        frequentQuestionsList.add("C#")
        frequentQuestionsList.add("Java")
        frequentQuestionsList.add("Javascript")
        frequentQuestionsList.add("Python")
        frequentQuestionsList.add("Dart")
        frequentQuestionsList.add("Kotlin")
        frequentQuestionsList.add("Typescript")

        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            frequentQuestionsList
        )
        frequentQuestionsLV.adapter = listAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (frequentQuestionsList.contains(query)) {
                    listAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@HelpActivity, "Aucune compatibilité...", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        finish()
    }
}