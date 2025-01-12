package com.example.invest_easy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.invest_easy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLimpar.setOnClickListener {
            println("deu certo" + binding.edtAporte.text)
            println("deu certo" + binding.edtMeses.text)
            println("deu certo" + binding.edtJuros.text)

        }





    }
}