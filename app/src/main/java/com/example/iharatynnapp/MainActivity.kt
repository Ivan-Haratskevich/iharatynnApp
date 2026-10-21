package com.example.iharatynnapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val header = findViewById<TextView>(R.id.main_header)
        val name = findViewById<EditText>(R.id.main_name)
        val second_name = findViewById<EditText>(R.id.main_second_name)
        val last_name = findViewById<EditText>(R.id.main_last_name)
        val full_name = findViewById<EditText>(R.id.main_full_name)
        val sum_button = findViewById<Button>(R.id.main_sum_button)

        sum_button.setOnClickListener {
            val nameText = name.text.toString().trim()
            val secondNameText = second_name.text.toString().trim()
            val lastNameText = last_name.text.toString().trim()

            if (nameText.isEmpty() || secondNameText.isEmpty() || lastNameText.isEmpty()) {
                header.text = "Заполните все поля!"
                return@setOnClickListener
            }

            // Фамилия Имя Отчество
            val result = "$secondNameText $nameText $lastNameText"
            full_name.setText(result)
            header.text = "Готово"
        }
    }
}