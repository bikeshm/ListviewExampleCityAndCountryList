package com.example.bikesh.cityandcountrylist.model;

/**
 * Created by bikesh on 2/1/2016.
 */
public class CityModel {
    public int id;
    public int countryId;
    public String name;

    public CityModel(int id, int cid, String name) {
        this.id = id;
        this.countryId = cid;
        this.name = name;
    }
}
