package com.example.giuaki_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TrangChu extends AppCompatActivity implements View.OnClickListener {

    private List<Item> lsItem;
    private Button btnAll,btnMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu);


        lsItem = new ArrayList<Item>();
        int idIMG = R.drawable.donut_red;

        lsItem.add(new Item(1,"item1",10.3,"Man",idIMG));
        lsItem.add(new Item(2,"item2",10,"Woman",idIMG));

        btnAll = findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);
        btnMan = findViewById(R.id.btnMan);
        btnMan.setOnClickListener(this);
        Button btnWoman = findViewById(R.id.btnWoman);
        btnWoman.setOnClickListener(this);
        Button btnChild = findViewById(R.id.btnChildren);
        btnChild.setOnClickListener(this);


        showALL(lsItem,"");

    }





    public void showALL(List<Item> lsItem,String filter){
        ListView lv = findViewById(R.id.lvItem);
        AdapterItem adapterItem ;
        List<Item> temp = new ArrayList<Item>();

        if(filter.equalsIgnoreCase("")) {
            temp = lsItem;
        }
        else if(filter.equalsIgnoreCase("man")){
            for(Item i : lsItem){
                if(i.getOption().equalsIgnoreCase("man")){
                    temp.add(i);
                }
            }
        }
        else if(filter.equalsIgnoreCase("woman")){
            for(Item i : lsItem){
                if(i.getOption().equalsIgnoreCase("woman")){
                    temp.add(i);
                }
            }
        }
        else if(filter.equalsIgnoreCase("children")){
            for(Item i : lsItem){
                if(i.getOption().equalsIgnoreCase("children")){
                    temp.add(i);
                }
            }
        }


        adapterItem = new AdapterItem(temp, this, R.layout.view_item);
        lv.setAdapter(adapterItem);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnAll){
            showALL(lsItem,"");
            resetBtn();
            btnAll.setBackgroundResource(R.drawable.btn_click);
        }
        if(view.getId() == R.id.btnMan){
            showALL(lsItem,"man");
            resetBtn();
            btnMan.setBackgroundResource(R.drawable.btn_click);
        

        }
        if(view.getId() == R.id.btnWoman){
            showALL(lsItem,"woman");
        }
        if(view.getId() == R.id.btnChildren){
            showALL(lsItem,"children");
        }
    }


    public void resetBtn(){
        btnAll.setBackgroundResource(R.drawable.btn_circle);
        btnMan.setBackgroundResource(R.drawable.btn_circle);

    }
}
