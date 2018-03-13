package com.example.q.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void on_admin(View v){
        Intent admin =new Intent(MainActivity.this,admin.class);
        startActivity(admin);
    }
    public  void on_new(View v){
        Intent new_1 =new Intent(MainActivity.this,newT.class);
        startActivity(new_1);
    }
    public  void on_curr(View v){
        Intent curr =new Intent(MainActivity.this,current.class);
        startActivity(curr);
    }
}
