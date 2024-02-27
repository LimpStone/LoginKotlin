package com.example.prueba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase

class Detalle: AppCompatActivity() {
    //val database = Firebase.database
    //val MyRef = database.getReference("Peliculas")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle)

        var nombre = findViewById<EditText>(R.id.NamePeli)
        var gender = findViewById<EditText>(R.id.TypeMovie)
        var anio = findViewById<EditText>(R.id.RealesePeli)
       // var imagn = findViewById<ImageView>(R.id.imageView)
        var edit = findViewById<Button>(R.id.Edit)
        var Remove = findViewById<Button>(R.id.Remove)
        val parametros = intent.extras

        if(parametros?.getCharSequence("Type")=="terror"){

        }
    }
}