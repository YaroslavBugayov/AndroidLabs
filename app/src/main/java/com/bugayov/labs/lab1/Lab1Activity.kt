package com.bugayov.labs.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.bugayov.labs.R

class Lab1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab1)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonOk.setOnClickListener {
            textResult.text = getText(R.string.result_text).toString() + " " + spinner.selectedItem.toString()
        }

        buttonCancel.setOnClickListener {
            textResult.text = ""
        }
    }
}