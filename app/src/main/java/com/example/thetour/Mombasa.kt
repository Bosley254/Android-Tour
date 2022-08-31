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
import java.util.jar.Manifest


class Mombasa : AppCompatActivity() {

    lateinit var payformombasa: Button
    lateinit var pigiamombasa: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mombasa)
        supportActionBar?.hide()

        payformombasa =findViewById(R.id.paymombasa)
        pigiamombasa = findViewById(R.id.btncallmombasa)

        payformombasa =findViewById(R.id.paymombasa)
        payformombasa.setOnClickListener{
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {
                startActivity(it)
            }



        //   val intent= Intent(this,Payment::class.java)
           // startActivity(intent)
           // Toast.makeText(this@Mombasa,"Success", Toast.LENGTH_LONG).show()
        }

       pigiamombasa!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Mombasa,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Mombasa,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
