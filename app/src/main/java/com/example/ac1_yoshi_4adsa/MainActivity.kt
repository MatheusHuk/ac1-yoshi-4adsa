package com.example.ac1_yoshi_4adsa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.text.DecimalFormat
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(v: View){

        val nome = et_nome.text
        val nota1 = et_n1.text
        val nota2 = et_n2.text

        if(nome.isEmpty() || nome.isBlank()) {
            Toast.makeText(this, "Campo nome está vazio", Toast.LENGTH_LONG).show()
            return
        }

        if(nota1.isBlank() || nota1.isEmpty()){
            Toast.makeText(this, "Campo nota 1 está vazio", Toast.LENGTH_LONG).show()
            return
        }

        if(nota2.isBlank() || nota2.isEmpty()){
            Toast.makeText(this, "Campo nota 2 está vazio", Toast.LENGTH_LONG).show()
            return
        }

        val realNome:String = nome.toString()
        val realNota1:Double = nota1.toString().toInt().toDouble()
        val realNota2:Double = nota2.toString().toInt().toDouble()

        if(realNota1 < 0 || realNota1 > 10 || realNota2 < 0 || realNota2 > 10){
            Toast.makeText(this, "Notas devem valer entre 0 e 10", Toast.LENGTH_LONG).show()
            return
        }

        val media:Double = ((realNota1 + realNota2)/2)

        var textColor:Int
        var situacao:String

        if(media >= 0 && media < 2){
            textColor = Color.RED
            situacao = "REPROVADO"
        }else if(media >= 2 && media < 5){
            textColor = Color.YELLOW
            situacao = "EM RECUPERAÇÃO"
        }else{
            textColor = Color.GREEN
            situacao = "APROVADO"
        }

        et_result_nome.setText("Aluno: ${realNome}")
        et_media_result.setText(media.toString())
        et_sit_result.setText(situacao)
        et_sit_result.setTextColor(textColor)

        et_result_nome.visibility = View.VISIBLE;
        et_media_result.visibility = View.VISIBLE;
        et_sit_result.visibility = View.VISIBLE;
        et_media_text.visibility = View.VISIBLE;
        et_sit_text.visibility = View.VISIBLE;
    }
}