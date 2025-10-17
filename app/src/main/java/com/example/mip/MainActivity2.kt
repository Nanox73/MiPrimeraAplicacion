package com.example.mip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val txtUsuario: TextView = findViewById(R.id.id_usuario_logeado)
        val recibirUsernameS = intent.getStringExtra("par_usern")
        val btnirCal: Button = findViewById(R.id.btn_calculadora)
        val btnIrMenu: Button = findViewById(R.id.btn_menu)
        val btnIrSpinner: Button = findViewById(R.id.btn_Spinner)
        val btnAct6: Button = findViewById(R.id.btn_act6)

        btnirCal.setOnClickListener {
            val nuevaVentana = Intent(this, MainActivity3::class.java)
                startActivity(nuevaVentana)
        }

        btnIrMenu.setOnClickListener{
            val nuevaVentana = Intent(this, MainActivity4::class.java)
                startActivity(nuevaVentana)
        }

        btnIrSpinner.setOnClickListener {
            val nuevaVentana = Intent(this, MainActivity5::class.java)
                startActivity(nuevaVentana)
        }

        btnAct6.setOnClickListener{
            val nuevaVentana = Intent(this, MainActivity6::class.java)
                startActivity(nuevaVentana)
        }



        txtUsuario.text = recibirUsernameS.toString()














        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}