package com.example.q.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class current : AppCompatActivity() {
     var id: EditText?=null
    var code: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.current)
        id=findViewById<View>(R.id.current_id) as EditText
        code=findViewById<View>(R.id.current_code) as EditText
    }

    fun Onsigin(view: View) {
        val id1=id!!.text.toString()
        val code1=code!!.text.toString()
        val type="sigin in"
        val backgroundWorker=backgroundWorker(this)
        backgroundWorker.execute(type, id1, code1)


    }
}
