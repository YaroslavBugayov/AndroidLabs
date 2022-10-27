package com.bugayov.labs.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import com.bugayov.labs.R

class Lab2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)

        findViewById<Button>(R.id.buttonOk).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.frameHolder,
                    Lab2ResultFragment(getText(R.string.result_text).toString() + " "
                            + findViewById<Spinner>(R.id.spinner)
                        .selectedItem
                        .toString())
                )
                .commit()
        }
    }
}