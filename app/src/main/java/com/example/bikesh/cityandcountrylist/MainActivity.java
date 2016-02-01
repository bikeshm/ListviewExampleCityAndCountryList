package com.example.bikesh.cityandcountrylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bikesh.cityandcountrylist.adapters.CityAdapter;
import com.example.bikesh.cityandcountrylist.adapters.CountryAdapter;
import com.example.bikesh.cityandcountrylist.model.CityModel;
import com.example.bikesh.cityandcountrylist.model.CountryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> mCountryList;
    ArrayList<CityModel> mCityList;

    ListView mLVCity, mLVCountry;

    CityAdapter mCityAdapter;

    CountryModel mSelectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLVCity = (ListView) findViewById(R.id.lv_city);
        mLVCountry = (ListView) findViewById(R.id.lv_country);

        mCountryList = new ArrayList<CountryModel>();
        mCityList = new ArrayList<CityModel>();

        //// TODO: get the country list by country code from db or some where

        //hardcoding values
        mCountryList.add(new CountryModel(1, "India"));
        mCountryList.add(new CountryModel(2, "Canada"));
        mCountryList.add(new CountryModel(3, "France"));


        mLVCountry.setAdapter(new CountryAdapter(this, mCountryList));

        mCityAdapter = new CityAdapter(this, mCityList);
        mLVCity.setAdapter(mCityAdapter);

    }

    public void loadCites(CountryModel selectedCountry) {

        mSelectedCountry = selectedCountry;
        mCityAdapter.clearList();

        //// TODO: get the city list by country code from db or some where

        //hardcoding values these values actually from db
        if (selectedCountry.id == 1) {
            mCityList.add(new CityModel(1, 1, "abc"));
            mCityList.add(new CityModel(2, 1, "def"));
            mCityList.add(new CityModel(3, 1, "ghi"));
        } else if (selectedCountry.id == 2) {
            mCityList.add(new CityModel(4, 2, "jkl"));
            mCityList.add(new CityModel(5, 2, "mno"));
        } else if (selectedCountry.id == 3) {
            mCityList.add(new CityModel(6, 3, "pqr"));
            mCityList.add(new CityModel(7, 3, "stu"));
        }
        //---

        mCityAdapter.notifyDataSetChanged();


    }

    public void citySelected(CityModel selectedCity) {
        Toast.makeText(MainActivity.this, mSelectedCountry.name + "/" + selectedCity.name, Toast.LENGTH_SHORT).show();
    }
}
