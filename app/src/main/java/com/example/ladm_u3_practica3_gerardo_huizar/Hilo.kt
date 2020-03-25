package com.example.ladm_u3_practica3_gerardo_huizar

import android.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class Hilo (p:MainActivity) : Thread(){
    var puntero = p
    var iniciar = false
    var score1 = 0
    var score2 = 0
    var score3 = 0
    var score4 = 0
    override fun run(){
        super.run()
        iniciar=true
        while (iniciar){
            sleep(1800)

            puntero.runOnUiThread {
                   //Aqui comenzara a hacer la rotacion de jugadores
                if(puntero.ronda <= 4){

                    //Indica que el primer player hara la jugada
                    if(puntero.jugaror == 1){
                        puntero.esp1.setText("Jugando")
                        puntero.esp2.setText("En espera")
                        puntero.esp3.setText("En espera")
                        puntero.esp4.setText("En espera")

                    }

                    if(puntero.jugaror == 2){
                        puntero.esp1.setText("En espera")
                        puntero.esp2.setText("Jugando")
                    }
                    if(puntero.jugaror == 3){
                        puntero.esp2.setText("En espera")
                        puntero.esp3.setText("Jugando")
                    }
                    if(puntero.jugaror == 4){
                        puntero.esp3.setText("En espera")
                        puntero.esp4.setText("Jugando")
                    }

                    puntero.diceOne = (1..6).random().toInt()
                    puntero.diceTwo = (1..6).random().toInt()

                    //Vamos a mostrar en pantalla la cara del dado segun el numero random obtenido

                    when(puntero.diceOne){
                        1->{
                            puntero.dice1.setImageResource(R.drawable.uno)
                        }
                        2->{
                            puntero.dice1.setImageResource(R.drawable.dos)
                        }
                        3->{
                            puntero.dice1.setImageResource(R.drawable.tres)
                        }
                        4->{
                            puntero.dice1.setImageResource(R.drawable.cuatro)
                        }
                        5->{
                            puntero.dice1.setImageResource(R.drawable.cinco)
                        }
                        6->{
                            puntero.dice1.setImageResource(R.drawable.seis)
                        }
                    }

                    //Turno del dado 2

                    when(puntero.diceTwo){
                        1->{
                            puntero.dice2.setImageResource(R.drawable.uno)
                        }
                        2->{
                            puntero.dice2.setImageResource(R.drawable.dos)
                        }
                        3->{
                            puntero.dice2.setImageResource(R.drawable.tres)
                        }
                        4->{
                            puntero.dice2.setImageResource(R.drawable.cuatro)
                        }
                        5->{
                            puntero.dice2.setImageResource(R.drawable.cinco)
                        }
                        6->{
                            puntero.dice2.setImageResource(R.drawable.seis)
                        }
                    }//Fin del when

            //Vamos a hacer la acomulacion del puntaje
                if (puntero.jugaror == 1){
                    score1 += puntero.diceOne + puntero.diceTwo
                    puntero.sco1.setText("${score1}")
                }

                 if (puntero.jugaror == 2){
                      score2 +=  puntero.diceOne + puntero.diceTwo
                      puntero.sco2.setText("${score2}")
                 }

                 if (puntero.jugaror == 3){
                     score3 +=  puntero.diceOne + puntero.diceTwo
                     puntero.sco3.setText("${score3}")
                 }

                 if (puntero.jugaror == 4){
                      score4 += puntero.diceOne + puntero.diceTwo
                      puntero.sco4.setText("${score4}")
                 }

                }//Fin del if de las rondas

                sleep(1200)
                puntero.jugaror++

                //Cuando se de la primera vuelta vamos a tener que pasasr nuevamente por los 4 jugadores
                if(puntero.jugaror>4){
                    puntero.jugaror=1
                    puntero.ronda++
                    puntero.lblnoRonda.setText("${puntero.ronda}")
                }

                //cuando terminen todas las rondas
                if(puntero.ronda>4){
                    iniciar=false
                    puntero.lblnoRonda.setText("4")

                }

            }//Fin de UiThread

        }//Fin del ciclo while
    //Obtenemos al ganador
        puntero.runOnUiThread {
            if(score1 > score2 && score1>score3 && score1 > score4){
                puntero.mensaje("Jugador 1")
            }
            if(score2 > score1 && score2>score3 && score2 > score4){
                puntero.mensaje("Jugador 2")
            }
            if(score3 > score1 && score3>score2 && score3 > score4){
                puntero.mensaje("Jugador 3")
            }

            if(score4 > score1 && score4>score2 && score4 > score3){
                puntero.mensaje("Jugador 4")
            }

        }

    }

}//Fin de la clase hilo