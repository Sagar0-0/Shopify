package com.example.android.shopify;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<ProductItem> arrayList;
    Context context;

    public ProductAdapter(ArrayList<ProductItem> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImageId());
        holder.productName.setText(arrayList.get(position).getProductName());
        holder.productPrice.setText(arrayList.get(position).getProductPrice());
        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(context,DetailActivity.class);
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView productName;
        TextView productPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
            productName=itemView.findViewById(R.id.item_name_text);
            productPrice=itemView.findViewById(R.id.item_price_text);
        }
    }
}
