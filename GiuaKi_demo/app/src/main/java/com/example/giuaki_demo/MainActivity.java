package com.example.giuaki_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGo =  findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);





    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGo){
            Intent intent = new Intent(this,TrangChu.class);
            startActivity(intent);
        }
    }
}