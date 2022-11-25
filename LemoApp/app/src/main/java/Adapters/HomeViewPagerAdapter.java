package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.lemoapp.GreenFruits;
import com.example.lemoapp.Home;
import com.example.lemoapp.NewFruits;
import com.example.lemoapp.R;
import com.example.lemoapp.SummerFruits;
import com.example.lemoapp.WinterFruits;

import java.util.List;

import Models.HomeViewPagerModel;

public class HomeViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<HomeViewPagerModel> arrayList;
    private LayoutInflater layoutInflater;

    public HomeViewPagerAdapter(Context context, List<HomeViewPagerModel> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.home_view_pager_item, container, false);

        TextView title;
        ImageView fruit;

        title = view.findViewById(R.id.title);
        fruit = view.findViewById(R.id.fruit);

        title.setText(arrayList.get(position).getTitle());
        fruit.setImageResource(arrayList.get(position).getFruit());

        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,arrayList.get(position).getTitle(),Toast.LENGTH_SHORT).show();

                switch (position) {

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

        return view;
    }
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
