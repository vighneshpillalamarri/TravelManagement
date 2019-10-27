package com.example.travelmanagement;

import com.google.firebase.database.Exclude;



public class Device {

    private String lastUpdated;
    private double latitude;
    private double longitude;


    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Device( String lastUpdated, double latitude, double longitude) {

        this.lastUpdated = lastUpdated;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Exclude
    public boolean equals(Device obj) {
        boolean b = true;


        if(!this.lastUpdated.equals(obj.getLastUpdated())){
            b = false;
        }

        if(! (this.latitude == obj.getLatitude())){
            b = false;
        }

        if(!(this.longitude == obj.getLongitude())){
            b = false;
        }

        return b;
    }

    public Device(){}
}