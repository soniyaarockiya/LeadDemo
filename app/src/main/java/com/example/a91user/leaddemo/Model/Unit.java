package com.example.a91user.leaddemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

//POJO for Unit
//Implements Parcelable so that it can pass data from one fragment to activity

public class Unit implements Parcelable {

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };
    String unitName, unitNumber;

    public Unit() {
    }


    public Unit(String unitName, String unitNumber) {
        this.unitName = unitName;
        this.unitNumber = unitNumber;
    }

    //IMPORTANT---Doesn't auto generate
    public Unit(Parcel in) {
        unitName = in.readString();
        unitNumber = in.readString();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //IMPORTANT---Doesn't auto generate
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeString(unitName);
            dest.writeString(unitNumber);
        }

    }
}