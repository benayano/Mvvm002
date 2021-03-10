package com.example.mvvm002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.firstTv)
        val editText: EditText = findViewById(R.id.editT)

        editText.doAfterTextChanged { text ->
           viewModel.onInputChange(text.toString())
       }

        viewModel.liveData.observe(this, Observer {
           textView.text = it.str
        })


    }
}