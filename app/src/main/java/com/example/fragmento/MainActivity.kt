package com.example.fragmento

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnFragmento: Button

    private lateinit var fragment1: BlankFragment1
    private lateinit var fragment2: BlankFragment2
    private lateinit var fragment3: BlankFragment3

    private var FragmentoTurno = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragmento = findViewById(R.id.btnFragmento)

        fragment1 = BlankFragment1()
        fragment2 = BlankFragment2()
        fragment3 = BlankFragment3()

        btnFragmento.setOnClickListener {
            IntercalarFragmentos(it)
        }

    }

    private fun IntercalarFragmentos(view: View) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        if (FragmentoTurno == 0) {
            //Instalar aqui el fragmento 1
            transaction.replace(R.id.reemplazarAqui, fragment1)
            transaction.addToBackStack(null)
            transaction.commit()
            FragmentoTurno++

        } else if (FragmentoTurno == 1) {
            //instalar aqui el fragmento 2
            transaction.replace(R.id.reemplazarAqui, fragment2)
            transaction.addToBackStack(null)
            transaction.commit()
            FragmentoTurno++

        } else if (FragmentoTurno == 2) {
            //instalar aqui el fragmento 3
            transaction.replace(R.id.reemplazarAqui, fragment3)
            transaction.addToBackStack(null)
            transaction.commit()
            FragmentoTurno = 0


        }
    }
}
