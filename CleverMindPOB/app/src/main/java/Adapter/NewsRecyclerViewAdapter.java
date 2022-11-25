package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clevermindpob.R;

import java.util.List;

import Model.NewsRecyclerViewModel;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<NewsRecyclerViewModel> listItems;

    public NewsRecyclerViewAdapter(Context context,List<NewsRecyclerViewModel> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsRecyclerViewModel item=listItems.get(position);
        holder.text.setText(item.getText());
        holder.img.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text=itemView.findViewById(R.id.text);
            img=itemView.findViewById(R.id.icon);
        }
    }
}
