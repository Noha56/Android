package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clevermindpob.Attend;
import com.example.clevermindpob.R;

import java.util.List;

import Model.TrainingCenterModel;

public class TrainingRecyclerViewAdapter extends RecyclerView.Adapter<TrainingRecyclerViewAdapter.ViewHolder>  {
    private Context context;
    private List<TrainingCenterModel> listItems;

    public TrainingRecyclerViewAdapter(Context context,List<TrainingCenterModel> listItems) {
        this.context=context;
        this.listItems = listItems;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.training_center_item,parent,false);
        return new TrainingRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int count=position;
        TrainingCenterModel item=listItems.get(position);
        holder.title.setText(item.getTitle());
        holder.day.setText(item.getDay());
        holder.time.setText(item.getTime());
        holder.desc.setText(item.getDesc());
        holder.price.setText(item.getPrice());
        holder.image.setImageResource(item.getImage());

    /*    holder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,day,time,info,desc,price;
        ImageView image,down;
        Button attendButton;
        int count=0;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            day=itemView.findViewById(R.id.day);
            time=itemView.findViewById(R.id.time);
            desc=itemView.findViewById(R.id.desc);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.image);
            down=itemView.findViewById(R.id.next);
            attendButton=itemView.findViewById(R.id.attendButton);

            attendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, Attend.class);
                    context.startActivity(intent);
                }
            });






        }
    }
}
