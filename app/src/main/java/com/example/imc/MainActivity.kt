package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.imc.extension.format
import com.example.imc.extension.valueDouble
import com.example.imc.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso.addTextChangedListener(DecimalTextWatcher(etPeso, 2) )
        etAltura.addTextChangedListener(DecimalTextWatcher(etAltura, 2))

        btCalcular.setOnClickListener{
            calcular()


        }


    }

    private fun calcular() {
        val peso = etPeso.valueDouble()
        var altura = etAltura.valueDouble()

        val imc = peso / (altura * altura)

        when(imc){
            in 0.0 .. 18.5 -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.magreza)
            in 18.6 .. 24.9 -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.peso_normal)
            in 25.0 .. 29.9 -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.sobre_peso)
            in 30.0 .. 34.9 -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.obesidade_grau_i)
            in 35.0 .. 39.9 -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.obesidade_grau_ii)
            else -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.obesidade_grau_iii)
        }


    }

    private fun configuraIMC(imc: Double, drawableId: Int, stringId: Int) {
        tvIMC.text = getString(R.string.seu_imc, imc.format(2))
        ivIMCStatus.setImageDrawable(
            ContextCompat.getDrawable(this, drawableId)
        )

        tvIMCStatus.text = getString(stringId)

    }
}
