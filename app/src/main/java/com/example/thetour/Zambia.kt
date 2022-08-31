package com.example.thetour

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Zambia : AppCompatActivity() {

    lateinit var payforzambia: Button
    lateinit var pigiazambia: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zambia)
        supportActionBar?.hide()

        payforzambia=findViewById(R.id.payzambia)
        pigiazambia=findViewById(R.id.btncallzambia)


        payforzambia=findViewById(R.id.payzambia)
        payforzambia.setOnClickListener{
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {
                startActivity(it)
            }


            // val intent= Intent(this,Payment::class.java)
            //  startActivity(intent)
            // Toast.makeText(this@Dubai,"Success", Toast.LENGTH_LONG).show()
        }

        pigiazambia!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Zambia,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Zambia,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
