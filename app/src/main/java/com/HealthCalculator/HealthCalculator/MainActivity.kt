package com.HealthCalculator.HealthCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()


        //Recuperei o Button e coloquei dentro da variavel do tipo Button
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val textoPeso: EditText =findViewById(R.id.text_Peso)
        val textoAltura: EditText= findViewById(R.id.text_Altura)



        //Colocar uma ação no Button, pega a variavel e coloca um . e coloca setOnClickListener...
        btnCalcular.setOnClickListener {


            val alturaStr = textoAltura.text.toString()
            val pesoStr = textoPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()


                val alturafinal: Float = altura * altura
                val result: Float = peso / alturafinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)

            } else {

                Toast.makeText(this,"Preencher todos os Campos",Toast.LENGTH_LONG).show()
            }

        }
    }
}
