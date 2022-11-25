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

import Models.FruitsRecyclerViewModel;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<FruitsRecyclerViewModel> listItems;

    public OrderAdapter(Context context, List<FruitsRecyclerViewModel> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        return new OrderAdapter.ViewHolder(view).linkAdapter(this);
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
        ImageView fruit_image, delete;
        OrderAdapter adapter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruit_name=itemView.findViewById(R.id.fruit_name);
            price=itemView.findViewById(R.id.price);
            fruit_image=itemView.findViewById(R.id.fruit_image);
            delete = itemView.findViewById(R.id.delete);

            delete.setOnClickListener(view -> {
                adapter.listItems.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
        }

        public ViewHolder linkAdapter(OrderAdapter adapter) {
            this.adapter = adapter;
            return this;
          }
        }
    }
