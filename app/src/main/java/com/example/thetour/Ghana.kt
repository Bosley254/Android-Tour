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


class Ghana : AppCompatActivity() {

    lateinit var payforghana: Button
    lateinit var pigiaghana: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ghana)
        supportActionBar?.hide()

        payforghana=findViewById(R.id.payghana)
        pigiaghana=findViewById(R.id.btncallghana)

        payforghana =findViewById(R.id.payghana)
        payforghana.setOnClickListener{
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {
                startActivity(it)
            }



            // val intent= Intent(this,Payment::class.java)
            //  startActivity(intent)
            // Toast.makeText(this@Dubai,"Success", Toast.LENGTH_LONG).show()
        }

        pigiaghana!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Ghana,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Ghana,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
