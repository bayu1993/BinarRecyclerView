package io.github.bayu1993.binarsesi3.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by dell on 3/27/18.
 */

public class Contact implements Parcelable{
    private String name;
    private String phone;
    private int imageProfile;

    public Contact(String name, String phone, int imageProfile) {
        this.name = name;
        this.phone = phone;
        this.imageProfile = imageProfile;
    }

    public Contact() {
    }

    protected Contact(Parcel in) {
        name = in.readString();
        phone = in.readString();
        imageProfile = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeInt(imageProfile);
    }
}
