package com.example.firstactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.firstactivity.databinding.FirstLayoutBinding

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.first_layout)

        // 方法1:直接用findViewById
//        val button1: Button = findViewById(R.id.button1)
//        button1.setOnClickListener {
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//        }

        // 方法2: ViewBinding
        val binding: FirstLayoutBinding = FirstLayoutBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.button1.setOnClickListener {
            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//            view.isVisible = false
//            val intent = Intent(this, SecondActivity::class.java)

//            val intent = Intent("com.example.firstactivity.ACTION_START")
//            intent.addCategory("com.example.firstactivity.MY_CATEGORY")

            // 隐式intent
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.bilibili.com")

            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.add_item -> {
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.remove_item -> {
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

