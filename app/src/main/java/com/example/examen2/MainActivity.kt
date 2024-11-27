package com.example.examen2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsuario : TextView
    private lateinit var txtContra : EditText
    private lateinit var btnEntrar : Button
    private lateinit var btnSalir : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        iniciarComponente()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponente(){
        txtUsuario = findViewById(R.id.txtUsuario) as EditText
        txtContra = findViewById(R.id.txtContra) as EditText
        btnEntrar = findViewById(R.id.btnEntrar) as Button
        btnSalir = findViewById(R.id.btnSalir) as Button
    }

    public fun eventosClic(){
        btnEntrar.setOnClickListener(View.OnClickListener {
            if (txtUsuario.text.toString().contentEquals(charSequence = "")|| txtContra.text.toString().contentEquals(charSequence = "")){
                Toast.makeText(this, "Falto ingresar algun dato", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, calculadora::class.java)
                intent.putExtra("Usuario", txtUsuario.text.toString())
                startActivity(intent)
            }
        })

        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}