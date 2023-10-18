package com.example.firstactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firstactivity.databinding.SecondLayoutBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.second_layout)
        binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")

        binding.button2.setOnClickListener {
            Toast.makeText(this, "You have clicked Button 2", Toast.LENGTH_SHORT).show()
        }
    }



}