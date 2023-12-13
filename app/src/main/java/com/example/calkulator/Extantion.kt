package com.example.calkulator

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.numShow(b : Button,  pl : EditText, char: Char) {
    b.setOnClickListener {
        pl.append(char.toString())
    }
}