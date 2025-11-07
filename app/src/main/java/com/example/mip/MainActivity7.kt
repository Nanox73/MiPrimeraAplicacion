package com.example.mip

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mip.API.InsertarAlumnosAPI


class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        val edNombre: EditText = findViewById(R.id.ed_nombre)
        val edApellido: EditText = findViewById(R.id.ed_apellido)
        val spUno: Spinner = findViewById(R.id.sp_uno)
        val spDos: Spinner = findViewById(R.id.sp_dos)
        val btnEnviar: Button = findViewById(R.id.btn_enviar)
        val bntSql: Button = findViewById(R.id.guardar_sql)


        val opcionesSpinnerUno = arrayOf(
            "1"
            ,"2"
            ,"3"
            ,"4"
            ,"5"
            ,"6"
            ,"7"
            ,"8"
            ,"9"
            ,"10"
            ,"11"
            ,"12"
            ,"13"
            ,"14"
            ,"15"
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionesSpinnerUno)

        spUno.adapter = adaptador


        val opcionesSpinnerDos = arrayOf(
            "1"
            ,"2"
            ,"3"
            ,"4"
            ,"5"
            ,"6"
            ,"7"
            ,"8"
            ,"9"
            ,"10"
        )
        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, opcionesSpinnerDos)

        spDos.adapter = adaptador2

        btnEnviar.setOnClickListener {
            InsertarAlumnosAPI.insertarAlumno(
                owner = this,
                context = this,
                nombre = edNombre.text.toString(),
                apellido = edApellido.text.toString(),
                grupo = spUno.selectedItem.toString(),
                seccion = spDos.selectedItem.toString(),
                archivoBytes = null,
                onSuccess = {
                    println("termino insert correcto")
                    Toast.makeText(this
                        , "guardado"
                        , Toast.LENGTH_SHORT)
                },
                onError = {
                    println("termino insert incorrecto")
                    Toast.makeText(this, "NO guardado", Toast.LENGTH_SHORT)
                }
            )
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}