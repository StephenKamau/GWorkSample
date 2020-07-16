package com.example.gwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gwork.databinding.ActivityTableLayoutBinding

class TableLayout : AppCompatActivity() {
    private var digit = 0
    private lateinit var binding: ActivityTableLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "TableLayout Example"
        binding.buttonOne.setOnClickListener {
            setDigit(1)
        }
        binding.buttonTwo.setOnClickListener {
            setDigit(2)
        }
        binding.buttonThree.setOnClickListener {
            setDigit(3)
        }
        binding.buttonFour.setOnClickListener {
            setDigit(4)
        }
        binding.buttonFive.setOnClickListener {
            setDigit(5)
        }
        binding.buttonSix.setOnClickListener {
            setDigit(6)
        }
        binding.buttonSeven.setOnClickListener {
            setDigit(7)
        }
        binding.buttonEight.setOnClickListener {
            setDigit(8)
        }
        binding.buttonNine.setOnClickListener {
            setDigit(9)
        }
        binding.buttonZero.setOnClickListener {
            setDigit(0)
        }
        binding.reset.setOnClickListener {
            binding.display.text = getString(R.string.start_typing)
        }
    }

    private fun setDigit(i: Int) {
        if (binding.display.text == getString(R.string.start_typing)) {
            binding.display.text = i.toString()
        } else {
            var value = binding.display.text.toString()
            value += i.toString()
            binding.display.text = value
        }
    }
}