package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.clevermindpob.R;

import java.util.ArrayList;
import java.util.List;

import Model.EventViewPagerModel;

public class EventViewPagerAdapter extends PagerAdapter
{
    private Context context;
    private List<EventViewPagerModel> arrayList;
    private LayoutInflater layoutInflater;

    public EventViewPagerAdapter(Context context, List<EventViewPagerModel> arrayList)
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
        View view = layoutInflater.inflate(R.layout.event_view_pager, container, false);

        TextView day,date,time;

        day = view.findViewById(R.id.day);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);

        day.setText(arrayList.get(position).getDay());
        date.setText(arrayList.get(position).getDate());
        time.setText(arrayList.get(position).getTime());

        container.addView(view, 0);
        return view;
    }
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
