package com.example.thetour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.thetour.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database: DatabaseReference
    lateinit var tologin: Button

    //lateinit var username: EditText
    //lateinit var enteremail: EditText
    //lateinit var phonenum: EditText
    //lateinit var passwad: EditText
    //lateinit var signinbtn: Button
    //lateinit var tologin: Button
    //firebase auth



    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.BtnSignUp.setOnClickListener {

            val username = binding.EdtUserL.text.toString()
            val email = binding.EdtMail.text.toString()
            val phoneNum = binding.EdtPhoneS.text.toString()
            val pass1 = binding.EdtPassL.text.toString()
            val pass2 = binding.EdtConf.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(username, email, phoneNum, pass1, pass2)
            database.child(username).setValue(User).addOnSuccessListener {

                binding.EdtUserL.text.clear()
                binding.EdtMail.text.clear()
                binding.EdtPhoneS.text.clear()
                binding.EdtPassL.text.clear()
                binding.EdtConf.text.clear()

                val intent = Intent(applicationContext, Home_a::class.java)
                startActivity(intent)
                Toast.makeText(this,"Successfully Joined",Toast.LENGTH_LONG).show()


            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }

        }

        tologin = findViewById(R.id.Btningiahuku)

        tologin.setOnClickListener {


                val intent = Intent(applicationContext, Thelogin::class.java)
                startActivity(intent)
                Toast.makeText(this,"Log in",Toast.LENGTH_LONG).show()

            }
        }



      //  supportActionBar?.hide()

      //  signinbtn = findViewById(R.id.BtnSignUp)
        //tologin = findViewById(R.id.Btningiahuku)
        //enteremail = findViewById(R.id.EdtMail)
        //passwad = findViewById(R.id.EdtPassL)
        //username = findViewById(R.id.EdtUserL)
        //phonenum = findViewById(R.id.EdtPhoneS)
        //firebaseAuth= FirebaseAuth.getInstance()




       // signinbtn.setOnClickListener {
         //   val intent = Intent(this, Home_a::class.java)
           // startActivity(intent)
            //Toast.makeText(this@MainActivity, "Sign Up Successful", Toast.LENGTH_LONG).show()
            //login()
            //val intent = Intent(applicationContext, Home_a::class.java)
            // startActivity(intent)
            //login()
            //username()
            //}
////            private fun updateUserName() {
////        val username = username.text.toString()
////        if (username.isEmpty()){
////            Toast.makeText(this, "input username", Toast.LENGTH_SHORT).show()
////        }else{
////            firebaseAuth.signInWithCredential(username)
////        }


        }

        //tologin.setOnClickListener {
         //val intent = Intent(this, Thelogin::class.java)
           // startActivity(intent)
            //Toast.makeText(this@MainActivity, "Proceeded to LogIn", Toast.LENGTH_LONG).show()
            //login()
            //val intent = Intent(applicationContext, Home_a::class.java)
            // startActivity(intent)
            //login()
            //username()
            //}
////            private fun updateUserName() {
////        val username = username.text.toString()
////        if (username.isEmpty()){
////            Toast.makeText(this, "input username", Toast.LENGTH_SHORT).show()
////        }else{
////            firebaseAuth.signInWithCredential(username)
////        }


//    //}
   //private fun login() {
    //val email = enteremail.text.toString()
    //val pass = passwad.text.toString()

       //calling signInWithEmailAndPassword(email, pass)
//         function using Firebase auth object
//         On successful response Display a Toast
      //  firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
        //   if (it.isSuccessful) {
          //  Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show()
           // } else
             //Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
       // }

    //}


 //}

//private fun FirebaseAuth.signInWithCredential(username: String) {

//}