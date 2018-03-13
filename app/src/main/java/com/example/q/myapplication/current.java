package com.example.q.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class current extends AppCompatActivity {
    EditText id, code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current);
        id = (EditText)findViewById(R.id.current_id);
        code = (EditText)findViewById(R.id.current_code);
    }
    public void Onsigin(View view) {
        String id1 = id.getText().toString();
        String code1 = code.getText().toString();
        String type = "sigin in";
        backgroundWorker backgroundWorker = new backgroundWorker(this);
        backgroundWorker.execute(type, id1, code1);


    }
}
