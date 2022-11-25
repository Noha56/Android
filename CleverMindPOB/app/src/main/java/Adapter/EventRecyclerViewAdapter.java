package Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clevermindpob.R;

import java.util.List;

import Model.EventRecyclerViewModel;
import Model.HomeRecyclerViewModel;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<EventRecyclerViewModel> listItems;
    public EventRecyclerViewAdapter(Context context,List<EventRecyclerViewModel> listItems) {
        this.context=context;
        this.listItems = listItems;
    }
    @NonNull
    @Override
    public EventRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventRecyclerViewAdapter.ViewHolder holder, int position) {
        EventRecyclerViewModel item=listItems.get(position);
        holder.text.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView bell,background;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            bell=itemView.findViewById(R.id.bell);
            background=itemView.findViewById(R.id.background);
            bell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    background.setImageResource(R.color.green2);
                }
            });
        }
    }
}
