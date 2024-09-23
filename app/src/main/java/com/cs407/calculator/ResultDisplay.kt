package com.cs407.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_display)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val calcResult = intent.getIntExtra("EXTRA",0)
        val isError = intent.getStringExtra("EXTRA_ERROR").isNullOrBlank()
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        if (!isError) {
            val string = "Divide by zero error"
            resultTextView.text = string

        } else {
            val resultString = "Result:$calcResult"
            resultTextView.text = resultString
        }

    }
}