package com.example.travelmanagement;
import com.google.firebase.database.Exclude;
public class Driver {
    private String name;
    private long experience;
    private long phoneNo;
    private long alcohol;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }
    public long getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(long alcohol) {
        this.alcohol = alcohol;
    }
    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }


    public Driver(long alcohol , long experience, String name, long phoneNo) {
        this.alcohol=alcohol;
        this.name = name;
        this.experience = experience;
        this.phoneNo = phoneNo;
    }

    @Exclude
    public boolean equals(Driver obj) {
        boolean b = true;


        if(!this.name.equals(obj.getName())){
            b = false;
        }

        if(! (this.experience == obj.getExperience())){
            b = false;
        }
        if(! (this.experience == obj.getAlcohol())){
            b = false;
        }
        if(!(this.phoneNo == obj.getPhoneNo())){
            b = false;
        }

        return b;
    }

    public Driver(){}
}
