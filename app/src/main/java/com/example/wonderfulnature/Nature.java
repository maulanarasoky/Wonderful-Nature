package com.example.wonderfulnature;

import android.os.Parcel;
import android.os.Parcelable;

public class Nature implements Parcelable {

    String the_title, short_description, photo;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
    }
    public Nature() {

    }
    protected Nature(Parcel in) {
        this.the_title = in.readString();
        this.short_description = in.readString();
        this.photo = in.readString();
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
