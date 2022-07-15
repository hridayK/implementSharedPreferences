package com.example.sharedpreferencesimplement

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        findViewById<Button>(R.id.addButton).setOnClickListener {
            val input = findViewById<EditText>(R.id.input).text.toString()
            editor.apply {
                putString("xd",input)
                apply()
            }
            Toast.makeText(this,input,Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.getButton).setOnClickListener {
            val outputField = findViewById<TextView>(R.id.output)
            var proof = sharedPref.getString("xd",null).toString()
            outputField.setText(proof)
        }
    }
}