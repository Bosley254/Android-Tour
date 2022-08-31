package com.example.thetour

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class Bali : AppCompatActivity() {

    lateinit var payforbali: Button
    lateinit var pigiabali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bali)
        supportActionBar?.hide()

        payforbali =findViewById(R.id.paybali)
        pigiabali=findViewById(R.id.btncallbali)

        payforbali =findViewById(R.id.paybali)
        payforbali.setOnClickListener{
            val simToolKitLaunchIntent=applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let {
                startActivity(it)
            }


            //   val intent= Intent(this,Payment::class.java)
            // startActivity(intent)
            // Toast.makeText(this@Mombasa,"Success", Toast.LENGTH_LONG).show()
        }

        pigiabali!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254707760130"))
            if (ContextCompat.checkSelfPermission(
                    this@Bali,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@Bali,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

    }
}
