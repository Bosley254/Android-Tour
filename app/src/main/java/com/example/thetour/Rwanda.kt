package com.example.thetour

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Rwanda : AppCompatActivity() {

    lateinit var payforrwanda: Button
    lateinit var pigiarwanda: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rwanda)
        supportActionBar?.hide()

        payforrwanda=findViewById(R.id.payzambia)
        pigiarwanda=findViewById(R.id.btncallzambia)

        payforrwanda =findViewById(R.id.payzambia)
        payforrwanda.setOnClickListener{
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {
                startActivity(it)
            }



            // val intent= Intent(this,Payment::class.java)
            //  startActivity(intent)
            // Toast.makeText(this@Dubai,"Success", Toast.LENGTH_LONG).show()
        }

        pigiarwanda!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Rwanda,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Rwanda,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
