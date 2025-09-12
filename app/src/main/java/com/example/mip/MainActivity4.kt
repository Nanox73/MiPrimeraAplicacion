package com.example.mip

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val boton: Button = findViewById(R.id.btn_calcular)
        val sPinner: Spinner = findViewById(R.id.sp_operaciones)
        val listVw: ListView = findViewById(R.id.list_vw)
        val txMensaje: TextView = findViewById(R.id.tx_mensaje4)


        val opcionesSpinner = arrayOf(
            "Sumar"
            , "Restar"
            , "Multiplicar"
            , "Hola Mundo"
            , "Dividir")

        //Adaptador d e Array
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionesSpinner

        )
        sPinner.adapter = adaptador







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}