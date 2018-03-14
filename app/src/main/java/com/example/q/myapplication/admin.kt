package com.example.q.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class admin : AppCompatActivity() {
    val UsernameEt: EditText?=null
    lateinit var PasswordEt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var UsernameEt: EditText
         var PasswordEt: EditText
        setContentView(R.layout.admin)
        setContentView(R.layout.admin)
        UsernameEt=findViewById<View>(R.id.etUserName) as EditText
        PasswordEt=findViewById<View>(R.id.etPassword) as EditText

    }

    fun OnLogin(view: View) {
        val username=UsernameEt!!.text.toString()
        val password=PasswordEt.text.toString()
        val type="login"
        val backgroundWorker=backgroundWorker(this)
        backgroundWorker.execute(type, username, password)
        val intent=Intent(this@admin, MainActivity::class.java)
        startActivity(intent)

    }
}
