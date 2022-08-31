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


class Paris : AppCompatActivity() {

    lateinit var payforparis: Button
    lateinit var pigiaparis: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paris)
        supportActionBar?.hide()

        payforparis=findViewById(R.id.payparis)
        pigiaparis=findViewById(R.id.btncallparis)

        payforparis =findViewById(R.id.payparis)
        payforparis.setOnClickListener{
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {
                startActivity(it)
            }



            // val intent= Intent(this,Payment::class.java)
            //  startActivity(intent)
            // Toast.makeText(this@Dubai,"Success", Toast.LENGTH_LONG).show()
        }

        pigiaparis!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Paris,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Paris,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
