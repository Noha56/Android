package Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clevermindpob.R;

import java.util.List;

import Model.HomeRecyclerViewModel;

public class AttendRecyclerViewAdapter  extends RecyclerView.Adapter<AttendRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<HomeRecyclerViewModel> listItems;
    int colors[]={R.color.green,R.color.blue,R.color.dark_blue};



    public AttendRecyclerViewAdapter(Context context,List<HomeRecyclerViewModel> listItems) {
        this.context=context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public AttendRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attend_recycler_item,parent,false);
        return new ViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeRecyclerViewModel item=listItems.get(position);
        holder.title.setText(item.getTitle());
        holder.day.setText(item.getDay());
        holder.time.setText(item.getTime());
        holder.attend.setText(item.getAttend());
        holder.img.setImageResource(item.getImage());
        holder.delete.setImageResource(item.getAttendIcon());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, day, time, attend;
        ImageView img, delete;
        AttendRecyclerViewAdapter adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            day = itemView.findViewById(R.id.day);
            time = itemView.findViewById(R.id.time);
            attend = itemView.findViewById(R.id.attend);
            img = itemView.findViewById(R.id.img);
            delete = itemView.findViewById(R.id.delete);

            delete.setOnClickListener(view -> {
                adapter.listItems.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
        }

        public ViewHolder linkAdapter(AttendRecyclerViewAdapter adapter) {
            this.adapter = adapter;
            return this;
        }
    }

}
