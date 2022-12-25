package com.example.homework61

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.homework61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val data = intent.getStringExtra(MainActivity.KEYFORINTENT)
            etSecond.setText(data)

            btnSecond.setOnClickListener {
                if (etSecond.text.isEmpty()) {
                    Toast.makeText(this@SecondActivity, getString(R.string.enter_text), Toast.LENGTH_SHORT).show()
                } else {
                    Intent(this@SecondActivity, MainActivity::class.java).apply {
                        putExtra(DATAKEY, etSecond.text.toString().trim())
                        setResult(RESULT_OK, this)
                        finish()
                    }
                }
            }

        }
    }
    companion object {
        const val DATAKEY = "DataKey"
    }
}