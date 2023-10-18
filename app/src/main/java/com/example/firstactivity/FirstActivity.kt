package com.example.firstactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
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


        // 使用 API LEVEL 30 后推荐的 Activity Result API
        // 1. 创建 ActivityResultContract (自定义/通用两种方式)
        val contract = ActivityResultContracts.StartActivityForResult()

        // 2. 注册结果回调
        val startForResult = registerForActivityResult(contract) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val intent = result.data
                val returnData = intent?.getStringExtra("text")
                Log.d("FirstActivity", "returned data is $returnData")
            }
        }

        binding.button1.setOnClickListener {
            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//            view.isVisible = false
//            val intent = Intent(this, SecondActivity::class.java)

//            val intent = Intent("com.example.firstactivity.ACTION_START")
//            intent.addCategory("com.example.firstactivity.MY_CATEGORY")

            // 隐式intent
            // 传递网页信息访问
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.bilibili.com")

            // 传递拨号信息
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")

            // 传递数据
//            val data = "Hello SecondActivity"
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", data)

            // 传递intent并在回掉中接受返回的数据(已被弃用)
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivityForResult()

            startForResult.launch(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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

