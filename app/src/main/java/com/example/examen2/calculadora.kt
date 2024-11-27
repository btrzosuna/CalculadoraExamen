package com.example.examen2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class calculadora : AppCompatActivity() {
    private lateinit var txtUsuario: TextView
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var txtResultado: TextView
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDivision: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        inicializarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun inicializarComponentes() {
        txtUsuario = findViewById(R.id.Usuario)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        txtResultado = findViewById(R.id.txtresultado)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnDivision = findViewById(R.id.btnDividir)
        btnMulti = findViewById(R.id.btnMulti)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        val usuario = intent.getStringExtra("Usuario")?: "Usuario desconocido"
        txtUsuario.setText("Usuario: "+ usuario)
    }
    fun eventosClic(){
        //Boton calcular
        btnSuma.setOnClickListener(View.OnClickListener{
            //Primero validamos que los campos tengan información
            if (txtNum1.text.toString().contentEquals("")
                || txtNum2.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar información", Toast.LENGTH_SHORT).show()
            }
            else{
                var num1 : Float = txtNum1.text.toString().toFloat()
                var num2 : Float = txtNum2.text.toString().toFloat()
                var resultado : Float = num1+num2
                txtResultado.text = resultado.toString()

            }
        })

        btnResta.setOnClickListener(View.OnClickListener{
            //Primero validamos que los campos tengan información
            if (txtNum1.text.toString().contentEquals("")
                || txtNum2.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar información", Toast.LENGTH_SHORT).show()
            }
            else{
                var num1 : Float = txtNum1.text.toString().toFloat()
                var num2 : Float = txtNum2.text.toString().toFloat()
                var resultado : Float = num1-num2
                txtResultado.text = resultado.toString()

            }
        })

        btnMulti.setOnClickListener(View.OnClickListener{
            //Primero validamos que los campos tengan información
            if (txtNum1.text.toString().contentEquals("")
                || txtNum2.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar información", Toast.LENGTH_SHORT).show()
            }
            else{
                var num1 : Float = txtNum1.text.toString().toFloat()
                var num2 : Float = txtNum2.text.toString().toFloat()
                var resultado : Float = num1*num2
                txtResultado.text = resultado.toString()

            }
        })
        btnDivision.setOnClickListener(View.OnClickListener{
            //Primero validamos que los campos tengan información
            if (txtNum1.text.toString().contentEquals("")
                || txtNum2.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar información", Toast.LENGTH_SHORT).show()
            }
            else{
                var num1 : Float = txtNum1.text.toString().toFloat()
                var num2 : Float = txtNum2.text.toString().toFloat()
                var resultado : Float = num1/num2
                txtResultado.text = resultado.toString()

            }
        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtResultado.text="Restultado"
            txtNum1.setText("")
            txtNum2.setText("")

        })
        btnRegresar.setOnClickListener({
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Calculadora")
            builder.setMessage("¿Deseas Regresar?")
            builder.setPositiveButton("Aceptar"){
                    dialog, wich ->
                finish()
            }
            builder.setNegativeButton("Cancelar"){
                    dialog, wich ->

            }
            builder.show()
        })
    }
}