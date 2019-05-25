package com.example.wonderfulnature;

import android.os.Parcel;
import android.os.Parcelable;

public class Nature implements Parcelable {

    String the_title, short_description, long_description, photo, other_name, location, time_zone, coordinates;

    public String getThe_title() {
        return the_title;
    }

    public void setThe_title(String the_title) {
        this.the_title = the_title;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.the_title);
        dest.writeString(this.short_description);
        dest.writeString(this.photo);
        dest.writeString(this.long_description);
        dest.writeString(this.other_name);
        dest.writeString(this.location);
        dest.writeString(this.time_zone);
        dest.writeString(this.coordinates);
    }
    public Nature() {

    }
    protected Nature(Parcel in) {
        this.the_title = in.readString();
        this.short_description = in.readString();
        this.long_description = in.readString();
        this.photo = in.readString();
        this.other_name = in.readString();
        this.location = in.readString();
        this.time_zone = in.readString();
        this.coordinates = in.readString();
    }
    public static final Parcelable.Creator<Nature> CREATOR = new Creator<Nature>() {
        @Override
        public Nature createFromParcel(Parcel source) {
            return new Nature(source);
        }

        @Override
        public Nature[] newArray(int size) {
            return new Nature[size];
        }
    };
}
