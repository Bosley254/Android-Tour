package com.example.thetour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Thelogin : AppCompatActivity() {

    lateinit var loginbtn: Button
    lateinit var userjina: EditText
    lateinit var userpass: EditText

    private lateinit var firebaseAuth: FirebaseAuth
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_login)

        supportActionBar?.hide()
        
        loginbtn = findViewById(R.id.BtnIngia)
        userjina = findViewById(R.id.EdtUserL)
        userpass = findViewById(R.id.EdtPassL)

        firebaseAuth= FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {
            val intent = Intent(this, Home_a::class.java)
            startActivity(intent)
            Toast.makeText(this@Thelogin, "Logged in Successful", Toast.LENGTH_LONG).show()
            //login()
            //val intent = Intent(applicationContext, Home_a::class.java)
            // startActivity(intent)
            //login()
            //username()
            //}
////            private fun updateUserName() {
////        val userjina = userjina.text.toString()
////        if (username.isEmpty()){
////            Toast.makeText(this, "input username", Toast.LENGTH_SHORT).show()
////        }else{
////            firebaseAuth.signInWithCredential(username)
////        }


        }
        
    }
}