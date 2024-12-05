package com.example.myapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFecha = findViewById<Button>(R.id.btnFecha)
        val tvFechaSeleccionada = findViewById<TextView>(R.id.tvFechaSeleccionada)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val etEmail = findViewById<EditText>(R.id.main)
        val etDescripcion = findViewById<EditText>(R.id.etDescripcion)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        // Selector de Fecha
        btnFecha.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val fecha = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tvFechaSeleccionada.text = fecha
            }, year, month, day)

            datePicker.show()
        }

        // Acción del botón Guardar
        btnGuardar.setOnClickListener {
            val telefono = etTelefono.text.toString()
            val email = etEmail.text.toString()
            val descripcion = etDescripcion.text.toString()
            val fechaNacimiento = tvFechaSeleccionada.text.toString()

            if (telefono.isBlank() || email.isBlank() || descripcion.isBlank() || fechaNacimiento == "No seleccionada") {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar un resumen del formulario (puedes guardar en base de datos o enviar a otro lado)
                Toast.makeText(this, "Contacto Guardado:\nTel: $telefono\nEmail: $email\nFecha: $fechaNacimiento\nDescripción: $descripcion", Toast.LENGTH_LONG).show()
            }
        }
    }
}

