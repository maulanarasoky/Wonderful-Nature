package com.example.wonderfulnature;

import android.os.Parcel;
import android.os.Parcelable;

public class Nature implements Parcelable {

    String the_title, short_description, long_description, photo, other_name, location, other_img_one, other_img_two, other_img_three;

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

    public String getOther_img_one() {
        return other_img_one;
    }

    public void setOther_img_one(String other_img_one) {
        this.other_img_one = other_img_one;
    }

    public String getOther_img_two() {
        return other_img_two;
    }

    public void setOther_img_two(String other_img_two) {
        this.other_img_two = other_img_two;
    }

    public String getOther_img_three() {
        return other_img_three;
    }

    public void setOther_img_three(String other_img_three) {
        this.other_img_three = other_img_three;
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
        dest.writeString(this.other_img_one);
        dest.writeString(this.other_img_two);
        dest.writeString(this.other_img_three);
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
        this.other_img_one = in.readString();
        this.other_img_two = in.readString();
        this.other_img_three = in.readString();
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
