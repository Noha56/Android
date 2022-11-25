package Adapter;

import static android.app.Activity.RESULT_OK;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clevermindpob.R;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;

import Model.JobRecyclerViewModel;
import Model.NewsRecyclerViewModel;


public class JobRecyclerViewAdapter  extends RecyclerView.Adapter<JobRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<JobRecyclerViewModel> listItems;

    public JobRecyclerViewAdapter(Context context,List<JobRecyclerViewModel> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.job_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobRecyclerViewModel item=listItems.get(position);
        holder.text.setText(item.getTitle());
        holder.exp.setText(item.getExp());
        holder.img.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text,exp;
        ImageView img ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.title);
            exp=itemView.findViewById(R.id.exp);
            img=itemView.findViewById(R.id.img);

        }
    }
}
