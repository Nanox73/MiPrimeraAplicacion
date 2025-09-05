package com.example.mip

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mip.funciones.OpMatematicas



class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val edNumuno: EditText = findViewById(R.id.ed_numUno)
        val edNumdos: EditText = findViewById(R.id.ed_numDos)
        val btnCalcular: Button = findViewById(R.id.btn_cal)
        val txMensaje: TextView = findViewById(R.id.tx_Mensaje)
        val txMensaje2: TextView = findViewById(R.id.tx_mensaje2)

        btnCalcular.setOnClickListener {
            var numeroUno: Int = edNumuno.text.toString().toIntOrNull() ?: 0
            var numeroDos: Int = edNumdos.text.toString().toIntOrNull() ?: 0

            txMensaje2.text = OpMatematicas.dividirValores(numeroUno, numeroDos)


        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}