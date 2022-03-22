package com.example.giuaki_demo;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class AdapterItem extends BaseAdapter {

    private List<Item> lsItem;
    private Context context;
    private int idLayout;


    public AdapterItem(List<Item> lsItem, Context context, int idLayout) {
        this.lsItem = lsItem;
        this.context = context;
        this.idLayout = idLayout;
    }

    @Override
    public int getCount() {
        if(lsItem.size() != 0 && !lsItem.isEmpty())
            return lsItem.size();

        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }

        ImageView img = (ImageView) view.findViewById(R.id.img_item);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvMoney = (TextView) view.findViewById(R.id.tvMoney);
        TextView tvOption = (TextView) view.findViewById(R.id.tvOption);

        Item item = lsItem.get(i);

        if(lsItem != null && !lsItem.isEmpty()){
            img.setImageResource(item.getIdIMG());
            tvName.setText(item.getName());
            tvMoney.setText("$ "+item.getMoney());
            tvOption.setText(item.getOption());

        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetail(item);

            }
        });

        return view;
    }

    public void showDetail(Item item){
        Intent intent = new Intent(context,Detial.class);
        Gson gson = new Gson();
        String itemString = gson.toJson(item);
        intent.putExtra("item",itemString);
        context.startActivity(intent);

    }


}
