package com.example.robert.calcimc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        skIdade.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                tvResultSK_Idade.text = (progress.toString() + " " + getText(R.string.Anos))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        skPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                tvResultSK_Peso.text = (progress.toString() + " " + getText(R.string.unitPeso))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        skAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                tvResultSK_Altura.text = (progress.toString() + " " + getText(R.string.unitAltura))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        btnCalcular.setOnClickListener {
            var isMulher = swtSexo.isChecked
            val idade = skIdade.progress.toString().toIntOrNull()
            val peso = skPeso.progress.toString().toIntOrNull()
            val altura = skAltura.progress.toString().toIntOrNull()

            if (idade == null || idade == 0){
                Toast.makeText(applicationContext, "Por favor, informe a idade", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (peso == null || peso == 0){
                Toast.makeText(applicationContext, "Por favor, informe o peso", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (altura == null || altura == 0){
                Toast.makeText(applicationContext, "Por favor, informe a altura", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val alturaM = altura / 100.0
            val imc = peso / (alturaM * alturaM)

            var str = ""
            var star = 0

            if (imc <= 18.5){
             str = getText(R.string.Result_Abaixo).toString()
                star = 3
            }else if (imc <= 24.9){
                str = getText(R.string.Result_Saudavel).toString()
                star = 5
            }else if (imc <= 29.9){
                str = getText(R.string.Result_Sobre).toString()
                star = 3
            }else if (imc > 30){
                str = getText(R.string.Result_Obesidade).toString()
                star = 1
            }

            tvResult_IMC.text = (getText(R.string.Result_IMC).toString() + " " + "%.2f".format(imc))
            tvResult_Nivel.text = str
            rbScore.rating = star.toFloat()
        }
    }
}
