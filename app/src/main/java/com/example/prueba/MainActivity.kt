package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLogin = findViewById<Button>(R.id.buttonLgn)
        auth = Firebase.auth
        btnLogin.setOnClickListener{
            auth.signInWithEmailAndPassword("hentaimaster@lolilov.com","UWUOWOAWA").addOnCompleteListener {
                task->
                if (task.isSuccessful){
                    Toast.makeText(this,"Logged in",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this,"Cagaste wn",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser==null){
            Toast.makeText(this,"No user find",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Logged LMAO?",Toast.LENGTH_LONG).show()
        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        auth.signOut()
    }
}