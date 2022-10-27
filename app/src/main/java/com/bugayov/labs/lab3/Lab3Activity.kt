package com.bugayov.labs.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.bugayov.labs.R

class Lab3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3)
        val database = LanguageDatabase.getDatabase(this)
        findViewById<Button>(R.id.buttonDatabase).setOnClickListener {
            Thread {
                if (database.languageDao().getCount() == 0) {
                    runOnUiThread {
                        Toast.makeText(this, getText(R.string.empty), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    startActivity(Intent(this, DatabaseActivity::class.java))
                }
            }.start()
        }
        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            Thread {
                val language = Language(null, findViewById<Spinner>(R.id.spinner).selectedItem.toString())
                database.languageDao().insert(language)
                runOnUiThread {
                    Toast.makeText(this, getText(R.string.successful), Toast.LENGTH_SHORT).show()
                }
            }.start()
        }
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            Thread {
                database.languageDao().clearTable()
            }.start()
        }
    }
}