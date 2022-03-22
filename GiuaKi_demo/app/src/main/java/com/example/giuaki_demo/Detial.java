package com.example.giuaki_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Detial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item);


        Intent intent = getIntent();
        String itemString = intent.getStringExtra("item");
        Gson gson = new Gson();
        Item item = gson.fromJson(itemString,Item.class);

        TextView tvName = findViewById(R.id.detail_Name);
        TextView tvGia = findViewById(R.id.detail_money);
        ImageView img = findViewById(R.id.detail_imgItem);

        tvName.setText(item.getName());
        tvGia.setText("$"+item.getMoney());
        img.setImageResource(item.getIdIMG());








    }
}
