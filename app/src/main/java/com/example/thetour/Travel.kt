package com.example.thetour


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class Travel : AppCompatActivity() {

    lateinit var mombasa: ImageView
    lateinit var bali: ImageView
    lateinit var ghana: ImageView
    lateinit var zambia: ImageView
    lateinit var paris: ImageView
    lateinit var egypt: ImageView
    lateinit var dubai: ImageView
    lateinit var rwanda: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)
        supportActionBar?.hide()

        mombasa=findViewById(R.id.mombasai)
        bali=findViewById(R.id.balii)
        ghana=findViewById(R.id.ghanai)
        zambia=findViewById(R.id.zambiai)
        paris=findViewById(R.id.parisi)
        egypt=findViewById(R.id.egypti)
        dubai=findViewById(R.id.dubaii)
        rwanda=findViewById(R.id.rwandai)


        mombasa=findViewById(R.id.mombasai)
        mombasa.setOnClickListener{
            val got= Intent(this,Mombasa::class.java)
            startActivity(got)
            Toast.makeText(this@Travel,"Mombasa", Toast.LENGTH_LONG).show()
        }


        bali=findViewById(R.id.balii)
        bali.setOnClickListener{
            val intent= Intent(this,Bali::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Bali", Toast.LENGTH_LONG).show()
        }

        ghana=findViewById(R.id.ghanai)
        ghana.setOnClickListener{
            val intent= Intent(this,Ghana::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Ghana", Toast.LENGTH_LONG).show()
        }

        zambia=findViewById(R.id.zambiai)
        zambia.setOnClickListener{
            val intent= Intent(this,Zambia::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Zambia", Toast.LENGTH_LONG).show()
        }

        paris=findViewById(R.id.parisi)
        paris.setOnClickListener{
            val intent= Intent(this,Paris::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Paris", Toast.LENGTH_LONG).show()
        }

        egypt=findViewById(R.id.egypti)
        egypt.setOnClickListener{
            val intent= Intent(this,Egypt::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Egypt", Toast.LENGTH_LONG).show()
        }

        dubai=findViewById(R.id.dubaii)
        dubai.setOnClickListener{
            val intent= Intent(this,Dubai::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Dubai", Toast.LENGTH_LONG).show()
        }

        rwanda=findViewById(R.id.rwandai)
        rwanda.setOnClickListener{
            val intent= Intent(this,Rwanda::class.java)
            startActivity(intent)
            Toast.makeText(this@Travel,"Rwanda", Toast.LENGTH_LONG).show()
        }


    }
}