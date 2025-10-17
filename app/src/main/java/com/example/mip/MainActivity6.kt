package com.example.mip

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)

        val listvIew: ListView = findViewById(R.id.ls_vw)

        val opcionesArr = arrayOf(
            "IR A CALCULADORA"
            , "IR MENU"
            , "Spinner rest api"
        )

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionesArr)

        listvIew.adapter = adaptador

        listvIew.setOnItemClickListener { parent, view, position, id ->
            val itemElegido = parent.getItemAtPosition(position).toString()
            if(itemElegido == "IR A CALCULADORA"){
                val nuevaVentan = Intent(this, MainActivity3::class.java)
                         startActivity(nuevaVentan)
            }
            if(itemElegido == "Spinner rest api"){
                val nuevaVentana2 = Intent(this,MainActivity7::class.java )
                         startActivity(nuevaVentana2)
            }
            Toast.makeText(this, itemElegido, Toast.LENGTH_SHORT).show()
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}