package com.example.ladm_u3_practica3_gerardo_huizar

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var hilo: Hilo? = null
    var ronda = 1
    var jugaror = 1
    var diceOne = 0
    var diceTwo = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Juego de Azar")

        iniciar.setOnClickListener {
            hilo = Hilo(this)
            hilo?.start()
        }//Fin del boton comenzar

    }//Fin del onCreate

    fun mensaje(mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle("Atencion")
            .setMessage("El ganador es: " + mensaje)
            .setPositiveButton("Aceptar") { d, i -> }
            .show()
    }



}
