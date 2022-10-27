package com.bugayov.labs.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bugayov.labs.R

class Lab2ResultFragment(private val language: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inf = inflater.inflate(R.layout.fragment_lab2_result, container, false)
        inf.findViewById<TextView>(R.id.textResult).text = language
        inf.findViewById<Button>(R.id.buttonCancel).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        }
        return inf
    }
}