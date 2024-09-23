package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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


        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)


        addButton.setOnClickListener {
            val number1 = findViewById<EditText>(R.id.number1).text.toString().toInt()
            val number2 = findViewById<EditText>(R.id.number2).text.toString().toInt()
            val intent = Intent(this, ResultDisplay::class.java)
            val input = number1 + number2
            intent.putExtra("EXTRA", input)
            startActivity(intent)
        }

        subtractButton.setOnClickListener {
            val number1 = findViewById<EditText>(R.id.number1).text.toString().toInt()
            val number2 = findViewById<EditText>(R.id.number2).text.toString().toInt()
            val intent = Intent(this, ResultDisplay::class.java)
            intent.putExtra("EXTRA", number1.toInt() - number2.toInt())
            startActivity(intent)
        }

        multiplyButton.setOnClickListener {
            val number1 = findViewById<EditText>(R.id.number1).text.toString().toInt()
            val number2 = findViewById<EditText>(R.id.number2).text.toString().toInt()
            val intent = Intent(this, ResultDisplay::class.java)
            intent.putExtra("EXTRA", number1.toInt() * number2.toInt())
            startActivity(intent)
        }

        divideButton.setOnClickListener {
            val number1 = findViewById<EditText>(R.id.number1).text.toString().toInt()
            val number2 = findViewById<EditText>(R.id.number2).text.toString().toInt()
            val intent = Intent(this, ResultDisplay::class.java)
            if (number2 == 0){
                intent.putExtra("EXTRA", "Divide by Zero Error")
                startActivity(intent)
            }
            else {
                intent.putExtra("EXTRA", number1 / number2)
                startActivity(intent)
            }
        }

    }
}