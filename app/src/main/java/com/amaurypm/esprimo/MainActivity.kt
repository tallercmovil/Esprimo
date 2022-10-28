package com.amaurypm.esprimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.amaurypm.esprimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val tvPrueba1 = findViewById<TextView>(R.id.tvPrueba1)
        tvPrueba1.text = "Amaury"*/



    }

    fun click(view: View) {
        val numero = binding.etNumero.text.toString().toInt()

        if(esPrimo(numero)){
            binding.tvResultado.text = "El número $numero sí es primo"
        }else{
            binding.tvResultado.text = "El número $numero no es primo"
        }
    }

    fun esPrimo(numero: Int): Boolean{
        if(numero<=1) return false
        for(i in 2 until numero){
            if(numero % i == 0) return false
        }
        return true
    }
}