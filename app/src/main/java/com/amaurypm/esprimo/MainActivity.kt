package com.amaurypm.esprimo

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amaurypm.esprimo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun click(view: View) {

        when(view.id){

            R.id.btnVerificar -> {
                if(binding.etNumero.text.isNotEmpty()) {

                    val numero = binding.etNumero.text.toString().toInt()

                    if (esPrimo(numero)) {
                        binding.tvResultado.text = getString(R.string.si_primo, numero, "!")
                    }else{
                        binding.tvResultado.text = getString(R.string.no_primo, numero)
                    }
                }else{
                    Toast.makeText(this@MainActivity, resources.getString(R.string.ingresa_valor), Toast.LENGTH_SHORT).show()
                    binding.etNumero.error = getString(R.string.valor_requerido)
                }
            }

            R.id.btnEs -> {
                setLocale("es")
            }

            R.id.btnEn -> {
                setLocale("en")
            }

            R.id.btnConf -> {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS));
            }

        }

    }

    fun esPrimo(numero: Int): Boolean{
        if(numero<=1) return false
        for(i in 2 until numero){
            if(numero % i == 0) return false
        }
        return true
    }

    fun setLocale(codigoIdioma: String){
        val config = resources.configuration
        val locale = Locale(codigoIdioma)
        Locale.setDefault(locale)

        config.setLocale(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            createConfigurationContext(config)

        resources.updateConfiguration(config, resources.displayMetrics)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}