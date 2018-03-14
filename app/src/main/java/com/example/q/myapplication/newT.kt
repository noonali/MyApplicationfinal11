package com.example.q.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

import java.util.Random

class newT : AppCompatActivity() {
     var id: EditText?=null
    var email: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_t)
        id=findViewById<View>(R.id.new_id) as EditText
        email=findViewById<View>(R.id.new_email) as EditText
    }

    fun Onsend(view: View) {
        val id1=id!!.text.toString()
        val email1=email!!.text.toString()
        val type="register1"
        val backgroundWorker=backgroundWorker(this)
        backgroundWorker.execute(type, id1, email1)
        val number=randomnumber()
        try {
            val sendemail=Intent(Intent.ACTION_SEND)
            sendemail.data=Uri.parse(number.toString())
            sendemail.type="message/rfc822"
            sendemail.putExtra(Intent.EXTRA_EMAIL, email as Parcelable)
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT")
            sendemail.putExtra(Intent.EXTRA_TEXT, "text")
            startActivity(sendemail)

        } catch (e: Exception) {
            //Toast.makeText(this," not send email",Toast.LENGTH_LONG).show();
        }

        //Intent intent= new Intent(app11.this,currentteacher.class);
        //startActivity(intent);

    }

    fun randomnumber(): Int {

        val rand=Random()

        return rand.nextInt(4)
    }
}
