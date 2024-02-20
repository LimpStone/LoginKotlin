package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
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
        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.editTextTextPassword)
       // "hentaimaster@lolilov.com" "UWUOWOAWA"
        auth = Firebase.auth
        btnLogin.setOnClickListener{
            if (email != null && password != null){
                Toast.makeText(this,email.toString(),Toast.LENGTH_LONG).show()
                auth.signInWithEmailAndPassword(email.toString(),password.toString()).addOnCompleteListener {
                        task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Logged in",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,Login::class.java))
                    }else{
                        Toast.makeText(this,"No entras pa",Toast.LENGTH_LONG).show()
                    }
                }
            }else{
                Toast.makeText(this,"You need a email / Password ape",Toast.LENGTH_LONG).show()
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
        auth.signOut()
        super.onDestroy()
    }
    override fun onKeyDown(keyCode:Int,event: KeyEvent?):Boolean{
        if(keyCode == KeyEvent.KEYCODE_BACK){
            auth.signOut()
        }
        return super.onKeyDown(keyCode, event)
    }
}