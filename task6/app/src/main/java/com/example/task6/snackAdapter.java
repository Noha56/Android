package com.example.task6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class snackAdapter extends RecyclerView.Adapter<snackAdapter.snackViewHolder> {

    String items[],meals[];
    int img [];
    Context context;
    public snackAdapter(Context context,String items[],String meals[],int img[] )
    {
        this.context=context;
        this.items=items;
        this.meals=meals;
        this.img=img;
    }

    @NonNull
    @Override
    public snackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.row_snack_item,parent,false);
        return new snackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull snackViewHolder holder, int position) {
    holder.item.setText(items[position]);
    holder.meal.setText(meals[position]);
    holder.background.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class snackViewHolder extends RecyclerView.ViewHolder {
        RadioButton item;
        RadioButton meal;
        ImageView background;
        int num = 0;

        public snackViewHolder(@NonNull View itemView) {
            super(itemView);
            item=itemView.findViewById(R.id.item_btn);
            meal=itemView.findViewById(R.id.meal_btn);
            background=itemView.findViewById(R.id.item_background);

            ImageView plus = itemView.findViewById(R.id.plus);
            ImageView minus = itemView.findViewById(R.id.minus);

            TextView count = itemView.findViewById(R.id.num_view);

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
