package com.example.bikesh.cityandcountrylist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bikesh.cityandcountrylist.MainActivity;
import com.example.bikesh.cityandcountrylist.R;
import com.example.bikesh.cityandcountrylist.model.CountryModel;

import java.util.ArrayList;

/**
 * Created by bikesh on 2/1/2016.
 */
public class CountryAdapter extends BaseAdapter {

    ArrayList<CountryModel> mCountryList;
    LayoutInflater mInflater;

    public CountryAdapter(Context context, ArrayList<CountryModel> countryList) {
        mCountryList = countryList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mCountryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCountryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCountryList.get(position).id;
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


        final CountryModel country = mCountryList.get(position);

        holder.name.setText(country.name);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) v.getContext()).loadCites(country);
            }
        });
        return convertView;
    }
}
