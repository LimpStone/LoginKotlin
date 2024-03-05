package com.example.prueba

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.Firebase
import com.google.firebase.database.database

class Detalle: AppCompatActivity() {
    val database = Firebase.database
    val myRef = database.getReference("Peliculas")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle)

        var nombre = findViewById<EditText>(R.id.NamePeli)
        var gender = findViewById<EditText>(R.id.TypeMovie)
        var anio = findViewById<EditText>(R.id.RealesePeli)
        var imagn = findViewById<ImageView>(R.id.imgDet)
        var edit = findViewById<Button>(R.id.Edit)
        var Remove = findViewById<Button>(R.id.Remove)
        val parametros = intent.extras

        nombre.setText(parametros?.getCharSequence("nombre").toString())
        gender.setText(parametros?.getCharSequence("genero").toString())
        anio.setText(parametros?.getCharSequence("anio").toString())

        if(parametros?.getCharSequence("genero") == "terror")
        {
            imagn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ecchi))
        }
        else if(parametros?.getCharSequence("genero") == "comedia")
        {
            imagn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nice))
        }
        else {
            imagn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.funny))
        }
        edit.setOnClickListener {
            var pelicula = PelisCampos(nombre.text.toString(),gender.text.toString(),anio.text.toString())
            myRef.child(parametros?.getCharSequence("id").toString()).setValue(pelicula).addOnCompleteListener {
                    task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Exito pelicula editada",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"Error"+task.exception!!.message.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }
        Remove.setOnClickListener {

            val builder: AlertDialog.Builder = MaterialAlertDialogBuilder(this)
            builder.setMessage("¿Estas seguro de eliminar esta pelicula)")
                .setPositiveButton("Aceptar"){ dialog, id ->


                    myRef.child(parametros?.getCharSequence("id").toString()).removeValue()
                        .addOnCompleteListener {
                                task ->
                            if(task.isSuccessful)
                            {
                                Toast.makeText(this,"Exito pelicula eliminada",Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                            }
                        }
                }
                .setNegativeButton("Cancelar"){
                        dialog, id ->
                }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}