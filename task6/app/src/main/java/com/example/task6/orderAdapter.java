package com.example.task6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.orderViewHolder>{
    String items[];
    int img [];
    int imgDesc[];
    Context context;
    public orderAdapter(Context context,int imgDesc[],String items[],int img[] )
    {
        this.context=context;
        this.imgDesc=imgDesc;
        this.items=items;
        this.img=img;
    }
    @NonNull
    @Override
    public orderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.row_order_item,parent,false);
        return new orderAdapter.orderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull orderViewHolder holder, int position) {
        holder.item.setText(items[position]);
        holder.imgDes.setImageResource(imgDesc[position]);
        holder.background.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class orderViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        ImageView background,imgDes;


        int num = 0;
        public orderViewHolder(@NonNull View itemView) {
            super(itemView);
            item=itemView.findViewById(R.id.item_name);
            background=itemView.findViewById(R.id.item_background);
            imgDes=itemView.findViewById(R.id.imgDes);

            ImageView plus = itemView.findViewById(R.id.plus);
            ImageView minus = itemView.findViewById(R.id.minus);

            TextView count = itemView.findViewById(R.id.counter);

            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    num = Integer.parseInt(count.getText().toString()) + 1;
                    count.setText(num + "");

                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (num > 0) {
                        num = Integer.parseInt(count.getText().toString())-1;
                        count.setText(num + "");
                    }

                }
            });

        }
    }
}
