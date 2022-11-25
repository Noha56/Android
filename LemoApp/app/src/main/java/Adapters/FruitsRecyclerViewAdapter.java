package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lemoapp.R;

import java.util.List;
import java.util.zip.Inflater;

import Models.FruitsRecyclerViewModel;
import Models.HomeRecyclerViewModel;

public class FruitsRecyclerViewAdapter extends RecyclerView.Adapter<FruitsRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<FruitsRecyclerViewModel> listItems;

    public FruitsRecyclerViewAdapter(Context context,List<FruitsRecyclerViewModel> listItems) {
        this.context=context;
        this.listItems = listItems;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        return new FruitsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FruitsRecyclerViewModel item=listItems.get(position);
        holder.fruit_image.setImageResource(item.getFruitImage());
        holder.fruit_name.setText(item.getFruitName());
        holder.price.setText(item.getPrice());


    }

    @Override
    public int getItemCount() {
       return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView fruit_name,price;
       ImageView fruit_image,plus,minus;
       int count=0,total=1,num=0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruit_name=itemView.findViewById(R.id.fruit_name);
            price=itemView.findViewById(R.id.price);
            fruit_image=itemView.findViewById(R.id.fruit_image);
            plus=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
            num=Integer.parseInt(price.getText().toString());
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    count+=1;
                    total=num*count;
                    price.setText(total+"");
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(count==0)
                    {
                        price.setText("0");
                    }
                    else
                    {
                        count=Math.abs(count-1);
                        total=num*count;
                        price.setText(total+"");
                    }


                }
            });



        }
    }
}
