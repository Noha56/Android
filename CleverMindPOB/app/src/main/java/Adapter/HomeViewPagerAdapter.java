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
import androidx.viewpager.widget.PagerAdapter;

import com.example.clevermindpob.News;
import com.example.clevermindpob.R;

import java.util.List;

import Model.HomeViewPagerModel;

public class HomeViewPagerAdapter extends PagerAdapter {
        private List<HomeViewPagerModel> model;
        private LayoutInflater layoutInflater;
        private Context context;

        public HomeViewPagerAdapter(List<HomeViewPagerModel> model,Context context) {
            this.model=model;
            this.context = context;
        }


        public int getCount() {
            return model.size();
        }


        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view.equals(object);
        }

        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //inflate view
            layoutInflater=LayoutInflater.from(context);
            View view =layoutInflater.inflate(R.layout.home_view_pager,container,false);

            ImageView imageView;
            TextView desc;

            imageView=view.findViewById(R.id.img);
            desc=view.findViewById(R.id.text);

          imageView.setImageResource(model.get(position).getImage());
          desc.setText(model.get(position).getDesc());

            container.addView(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,model.get(position).getDesc(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, News.class);
                    context.startActivity(intent);
                }
            });

            return view;
        }

        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }
}
