package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clevermindpob.Attend;
import com.example.clevermindpob.Home;
import com.example.clevermindpob.R;
import com.example.clevermindpob.TrainingCenter;

import java.util.List;

import Model.HomeRecyclerViewModel;
import Model.TrainingCenterModel;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<HomeRecyclerViewModel> listItems;
    int colors[]={R.color.green,R.color.blue,R.color.dark_blue};

    public HomeRecyclerAdapter(Context context,List<HomeRecyclerViewModel> listItems) {
        this.context=context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycle_item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerAdapter.ViewHolder holder, int position) {
        HomeRecyclerViewModel item=listItems.get(position);
        holder.title.setText(item.getTitle());
        holder.day.setText(item.getDay());
        holder.time.setText(item.getTime());
        holder.attend.setText(item.getAttend());
        holder.img.setImageResource(item.getImage());
        holder.attendIcon.setImageResource(item.getAttendIcon());

        //holder.day.setTextColor(colors[position]);
        //holder.time.setTextColor(colors[position]);



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,day,time,attend;
        ImageView img,attendIcon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            day=itemView.findViewById(R.id.day);
            time=itemView.findViewById(R.id.time);
            attend=itemView.findViewById(R.id.attend);
            img=itemView.findViewById(R.id.img);
            attendIcon=itemView.findViewById(R.id.attendIcon);
            attendIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,TrainingCenter.class);
                    context.startActivity(intent);
                }
            });
            attend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,TrainingCenter.class);
                    context.startActivity(intent);
                }
            });




        }
    }
}
