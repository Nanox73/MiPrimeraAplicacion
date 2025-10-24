package com.example.mip

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mip.Pcamara.CameraManager
import com.example.mip.Pcamara.CamaraUtils

class MainActivity9 : AppCompatActivity() {
    private var cameraManager: CameraManager? = null
    private lateinit var btnTomFot: Button
    private lateinit var imagenFoto: ImageView
    private lateinit var previewView: PreviewView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main9)


        val btnTomFot: Button = findViewById(R.id.btn_tom_foto)
        val imagenFoto: ImageView = findViewById(R.id.image_foto)
        val previewView: PreviewView  = findViewById(R.id.previewView)


        btnTomFot.isEnabled = false

        // Permiso
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            setupCamera()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                101
            )
        }

        btnTomFot.setOnClickListener {
            cameraManager?.takePhoto { bitmap ->
                if (bitmap != null) {
                    imagenFoto.setImageBitmap(bitmap)
                    val base64 = CamaraUtils.convertirDeBitMapABase64(bitmap)
                    Log.d("BASE64", base64.take(100) + "...")
                    Toast.makeText(this, "Foto capturada", Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this, "Error al capturar", Toast.LENGTH_SHORT).show()
                }
            } ?: Toast.makeText(this, "Cámara no lista", Toast.LENGTH_SHORT).show()
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}