package com.example.bikesh.cityandcountrylist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bikesh.cityandcountrylist.MainActivity;
import com.example.bikesh.cityandcountrylist.R;
import com.example.bikesh.cityandcountrylist.model.CityModel;

import java.util.ArrayList;

/**
 * Created by bikesh on 2/1/2016.
 */
public class CityAdapter extends BaseAdapter {

    ArrayList<CityModel> mCityList;

    LayoutInflater mInflater;

    public CityAdapter(Context context, ArrayList<CityModel> cityList) {
        mCityList = cityList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mCityList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCityList.get(position).id;
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final CityModel city = mCityList.get(position);
        holder.name.setText(city.name);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) v.getContext()).citySelected(city);
            }
        });
        return convertView;
    }

    public void clearList() {
        mCityList.clear();
    }
}
