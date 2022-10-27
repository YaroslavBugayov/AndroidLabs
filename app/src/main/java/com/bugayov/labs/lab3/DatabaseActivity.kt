package com.bugayov.labs.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.asLiveData
import com.bugayov.labs.R

class DatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        val database = LanguageDatabase.getDatabase(this)
        database.languageDao().getAllLanguages().asLiveData().observe(this) { list ->
            list.forEach {
                findViewById<TextView>(R.id.textViewList).append(it.language + "\n")
            }
        }
    }
}