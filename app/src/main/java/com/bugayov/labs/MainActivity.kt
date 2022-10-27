package com.bugayov.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bugayov.labs.lab1.Lab1Activity
import com.bugayov.labs.lab2.Lab2Activity
import com.bugayov.labs.lab3.Lab3Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonLab1).setOnClickListener {
            startActivity(Intent(this, Lab1Activity::class.java))
        }
        findViewById<Button>(R.id.buttonLab2).setOnClickListener {
            startActivity(Intent(this, Lab2Activity::class.java))
        }
        findViewById<Button>(R.id.buttonLab3).setOnClickListener {
            startActivity(Intent(this, Lab3Activity::class.java))
        }

    }
}