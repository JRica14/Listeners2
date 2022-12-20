package com.example.listeners2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.doAfterTextChanged
import com.example.listeners2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.isEnabled = false

        binding.editTextTextPersonName.setOnFocusChangeListener { view, b ->
            binding.textView.text = "EditText1"
        }
        binding.editTextTextPersonName2.setOnFocusChangeListener { view, b ->

                binding.textView.text = "EditText2"
        }

        binding.editTextTextPersonName2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button.isEnabled = binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPersonName2.text.isNotEmpty()
            }
        })

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button.isEnabled = binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPersonName2.text.isNotEmpty()
            }
        })



        binding.button.setOnClickListener { concatenar()}
    }

    fun concatenar(){
        var editT= binding.editTextTextPersonName
        var editT2= binding.editTextTextPersonName2
        editT.text.insert(editT.text.length, editT2.text)
    }



}