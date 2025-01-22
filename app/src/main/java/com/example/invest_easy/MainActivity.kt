package com.example.invest_easy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.invest_easy.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private fun formatarMoeda(valor: Double): String {
        val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return formatador.format(valor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalcular.setOnClickListener {

            val tempaporte = binding.edtAporte.text
            val tempmeses = binding.edtMeses.text
            val tempjuros = binding.edtJuros.text

            if ( tempaporte?.isEmpty() == true ||
                tempmeses?.isEmpty() == true ||
                tempjuros?.isEmpty() == true
                ) {
                Snackbar
                    .make(
                        binding.edtAporte,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    ).show()

            } else {

                val aporte: Float = binding.edtAporte.text.toString().toFloat()
                val meses: Int = binding.edtMeses.text.toString().toInt()
                val juros: Float = binding.edtJuros.text.toString().toFloat()

                val decimalJuros = juros / 100

                val montanteFinal = aporte * ((1 + decimalJuros).pow(meses) -1) / decimalJuros
                val totalaporte = aporte * meses
                val rendimentos = montanteFinal - totalaporte


                binding.tvValorfinal.text = formatarMoeda(montanteFinal.toDouble())
                binding.tvFinalrendimentos.text = formatarMoeda(rendimentos.toDouble())

            }
        }

        binding.btnLimpar.setOnClickListener {

            binding.tvValorfinal.text = "0.0"
            binding.tvFinalrendimentos.text = "0.0"
            binding.edtAporte.setText("")
            binding.edtMeses.setText("")
            binding.edtJuros.setText("")

        }

    }
}