package com.example.q.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun on_admin(v: View) {
        
        var admin= Intent(this,MainActivity::class.java)
        startActivity(admin)
        
    }

    fun on_new(v: View) {
        var admin= Intent(this,MainActivity::class.java)
        startActivity(admin)
        val new_1=Intent(this@MainActivity, newT::class.java)
        startActivity(new_1)
       
    }

    fun on_curr(v: View) {
        val curr=Intent(this@MainActivity, current::class.java)
        startActivity(curr)
    }
}
