package com.example.gwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.gwork.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private val towns =
        listOf("Nairobi", "Nakuru", "Mombasa", "Kisumu", "Eldoret", "Malaba", "Narok", "Bungoma")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, towns.sorted())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.nameTextInput.editText?.setOnKeyListener { _, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                binding.nameTextView.text = binding.nameTextInput.editText?.text.toString()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
        binding.spinner.onItemSelectedListener = this
        binding.materialButtonToggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            switchToggleLightsOn(checkedId, isChecked)
        }
        binding.javaCheckBox.setOnCheckedChangeListener { _, isChecked ->
            checkBoxHandler(isChecked, "Java")
        }
        binding.kotlinCheckBox.setOnCheckedChangeListener { _, isChecked ->
            checkBoxHandler(isChecked, "Kotlin")
        }
        binding.radioGroup.setOnCheckedChangeListener { _, id ->
            radioButtonHandler(id)
        }
    }

    private fun radioButtonHandler(id: Int) {
        when (id) {
            R.id.maleRadioButton -> showSnackBar("You selected male")
            R.id.femaleRadioButton -> showSnackBar("You selected female")
            R.id.nonBinaryRadioButton -> showSnackBar("You selected non-binary")
        }
    }

    private fun checkBoxHandler(isChecked: Boolean, programmingLanguage: String) {
        when {
            isChecked -> showSnackBar("You checked $programmingLanguage")
            else -> showSnackBar("You unchecked $programmingLanguage")
        }
    }

    private fun switchToggleLightsOn(checkedId: Int, isChecked: Boolean) {
        when (checkedId) {
            R.id.toggleButtonA -> {
                if (isChecked) {
                    showSnackBar("Light A switched ON")
                } else {
                    showSnackBar("Light A switched OFF")
                }
            }
            R.id.toggleButtonB -> {
                if (isChecked) {
                    showSnackBar("Light B switched ON")
                } else {
                    showSnackBar("Light B switched OFF")
                }
            }
            R.id.toggleButtonC -> {
                if (isChecked) {
                    showSnackBar("Light C switched ON")
                } else {
                    showSnackBar("Light C switched OFF")
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showSnackBar("Your town is: ${parent?.getItemAtPosition(position).toString()}")
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(findViewById(R.id.mainLayout), message, Snackbar.LENGTH_LONG).show()
    }
}