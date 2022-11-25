package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lemoapp.GreenFruits;
import com.example.lemoapp.NewFruits;
import com.example.lemoapp.R;
import com.example.lemoapp.SummerFruits;
import com.example.lemoapp.WinterFruits;

import java.util.List;

import Models.HomeRecyclerViewModel;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<HomeRecyclerViewModel> listItems;
    public HomeRecyclerViewAdapter(Context context,List<HomeRecyclerViewModel> listItems) {
        this.context=context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewAdapter.ViewHolder holder, int position) {
        HomeRecyclerViewModel item=listItems.get(position);
        holder.text.setText(item.getTitle());
        int count=position;
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (count) {
                    case 0:
                        Intent intent = new Intent(context, SummerFruits.class);
                        context.startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(context, NewFruits.class);
                        context.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(context, WinterFruits.class);
                        context.startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(context, GreenFruits.class);
                        context.startActivity(intent3);
                        break;

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.title);
        }
    }
}
