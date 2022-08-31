package com.example.thetour

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Feedback : AppCompatActivity() {
    var firebase = Firebase

    var feedname : EditText?= null
    var feedmail : EditText?= null
    var feedf : EditText?= null
    var buttonsub : Button?= null
    var buttonSms: Button?= null
    var buttonemail: Button?= null
    lateinit var pigiafeedback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        feedname = findViewById(R.id.feedname)
        feedmail = findViewById(R.id.EdtMail)
        feedf = findViewById(R.id.feedbackf)
        buttonsub = findViewById(R.id.BtnSubF)
        buttonSms = findViewById(R.id.btnmessage)
        buttonemail = findViewById(R.id.btnemailus)
        pigiafeedback = findViewById(R.id.btncallfeedb)

        buttonSms!!.setOnClickListener{
            val uri: Uri = Uri.parse("smsto:0707760130")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Niaje...")
            startActivity(intent)
        }

        buttonemail!!.setOnClickListener{
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "joshuaombui4@gmail.com",null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT,"Dear Sir")
            startActivity(Intent.createChooser(emailIntent,"Send Email..."))
        }

        buttonsub!!.setOnClickListener{
            val feeedname = feedname!!.text.toString().trim()
            val feeedmail = feedmail!!.text.toString().trim()
            val feeedf = feedf!!.text.toString().trim()
            //check if user has submitted empty fields
            if (feeedname.isEmpty()){
                feedname!!.setError("Please Enter ur Username")
                feedname!!.requestFocus()
            }else if (feeedmail.isEmpty()){
                feedmail!!.setError("Please Enter ur Email")
                feedmail!!.requestFocus()
            }else if (feeedf.isEmpty()){
                feedf!!.setError("Please Enter ur Phone NO")
                feedf!!.requestFocus()
            }else{
                //proceed to save the info
                //start by creating the User Object
                val userData = Subfeed(feeedname,feeedmail,feeedf,)
                //create a reference to store
                val reference = FirebaseDatabase.getInstance().
                getReference().child("Subfeed/$feeedname")
                //start saving user data
                reference.setValue(userData).addOnCompleteListener{
                        task->
                    if (task.isSuccessful){
                        Toast.makeText(applicationContext, "Your Feedback saved successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext, "Feedback Not Saved, Try  Again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        buttonsub!!.setOnClickListener{
            val goTohome= Intent(applicationContext,Home_a::class.java)
            startActivity(goTohome)
        }

        pigiafeedback!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Feedback,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Feedback,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}