package com.example.thetour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class Home_a: AppCompatActivity() {
   lateinit var cardabout :ImageView
   lateinit var cardtours : ImageView
   lateinit var cardfeedback : ImageView
   lateinit var cardcontact : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cardabout= findViewById(R.id.image1)
        cardtours = findViewById(R.id.image2)
        cardcontact = findViewById(R.id.image4)
        cardfeedback = findViewById(R.id.image3)

        //setting onclick listeners
        cardabout!!.setOnClickListener{
            val gotoabout=Intent(applicationContext,About::class.java)
            startActivity(gotoabout)
        }

        cardfeedback!!.setOnClickListener{
            val gotofeedback=Intent(applicationContext,Feedback::class.java)
            startActivity(gotofeedback)
        }

        cardtours!!.setOnClickListener{
            val gototours=Intent(applicationContext,Travel::class.java)
            startActivity(gototours)
        }

        cardcontact!!.setOnClickListener{
            val gotocontact=Intent(applicationContext,Contact::class.java)
            startActivity(gotocontact)
        }

    }
}