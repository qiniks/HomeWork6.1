package com.example.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val data = it.data?.getStringExtra(SecondActivity.DATAKEY).toString()
            binding.etFirst.setText(data)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnFirst.setOnClickListener {
                if (etFirst.text.isEmpty()) {
                    Toast.makeText(this@MainActivity, getString(R.string.enter_text), Toast.LENGTH_SHORT).show()
                } else {
                    Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra(KEYFORINTENT, etFirst.text.toString())
                        launcher.launch(this)
                    }
                }
            }
        }
    }
    companion object {
        const val KEYFORINTENT = "DataKey"
    }
}