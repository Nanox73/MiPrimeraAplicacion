package com.example.mip

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
        val botonVolver: Button = findViewById(R.id.btn_volver)


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


        val opcionesListView = arrayOf(
            "ps1"
            , "ps2"
            , "ps3"
            , "ps4"
            , "pa5"
            , "ps6"
            , "ps7"
            ,"ps8"
            , "ps9"
            , "ps10"
            , "ps11"
            , "ps12"
            , "ps13"
            , "ps14"
            , "ps14"
            , "ps15"
            , "ps16"
            , "ps17"
        )

        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionesListView)

        listVw.adapter = adaptador2

        boton.setOnClickListener {
            var str_opselected = sPinner.selectedItem.toString()
            val toast = Toast.makeText(this, str_opselected, Toast.LENGTH_SHORT)
            toast.show()
        }

        botonVolver.setOnClickListener{
            val nuevaVentana = Intent(this, MainActivity2::class.java)
            startActivity(nuevaVentana)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}