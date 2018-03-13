package com.example.q.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class newT extends AppCompatActivity {
    EditText id, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_t);
        id = (EditText)findViewById(R.id.new_id);
        email = (EditText)findViewById(R.id.new_email);
    }
    public void Onsend(View view) {
        String id1 = id.getText().toString();
        String email1= email.getText().toString();
        String type = "register";
        backgroundWorker backgroundWorker = new backgroundWorker(this);
        backgroundWorker.execute(type, id1, email1);
        int number=randomnumber();
         try{
             Intent sendemail=new Intent(Intent.ACTION_SEND);
             sendemail.setData(Uri.parse(String.valueOf(number)));
             sendemail.setType("message/rfc822");
             sendemail.putExtra(Intent.EXTRA_EMAIL, (Parcelable) email);
             sendemail.putExtra(Intent.EXTRA_SUBJECT,"SUBJECT");
             sendemail.putExtra(Intent.EXTRA_TEXT,"text");
             startActivity(sendemail);

         } catch (Exception e){
             //Toast.makeText(this," not send email",Toast.LENGTH_LONG).show();
         }
        //Intent intent= new Intent(app11.this,currentteacher.class);
        //startActivity(intent);

    }
    public int randomnumber(){

        Random rand = new Random();

        int  n = rand.nextInt(4);
        return n;
    }
}
