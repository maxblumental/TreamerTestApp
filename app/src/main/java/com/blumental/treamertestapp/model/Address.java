package com.blumental.treamertestapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(Parcel in) {
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipcode = in.readString();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(street);
        dest.writeString(suite);
        dest.writeString(city);
        dest.writeString(zipcode);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
