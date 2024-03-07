package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.database.database
class AddMov : AppCompatActivity()  {
    val database = Firebase.database
    val myRef = database.getReference("Pelicula")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var nombre = findViewById<EditText>(R.id.AddName)
        var genero = findViewById<EditText>(R.id.AddGender)
        var anio = findViewById<EditText>(R.id.AddRealese)
        var agregar = findViewById<Button>(R.id.agregar_peli)

        agregar.setOnClickListener {
            var pelicula = PelisCampos(nombre.text.toString(), genero.text.toString(), anio.text.toString())
            myRef.push().setValue(pelicula).addOnCompleteListener{
                    task ->

                if(task.isSuccessful)
                {
                    Toast.makeText(this,"Exito Pelicula agregada", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this,"Error"+task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}