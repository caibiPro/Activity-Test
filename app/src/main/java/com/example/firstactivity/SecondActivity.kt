package com.example.firstactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstactivity.databinding.SecondLayoutBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.second_layout)
        binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 接受切换过来的intent中携带的数据
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")

        binding.button2.setOnClickListener {
            Toast.makeText(this, "You have clicked Button 2", Toast.LENGTH_SHORT).show()
            // 将数据返回Intent供调用者
            setIntent()
            finish()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        setIntent()
        finish()
        super.onBackPressed()
    }

    private fun setIntent() {
        val resultIntent = Intent().apply { putExtra("text", "Callback Test") }
        setResult(RESULT_OK, resultIntent)
    }
}