package com.example.homeworkweek4day2;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String first;
    private String last;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String age;
    private String imageUrl;


    protected User(Parcel in) {
        first = in.readString();
        last = in.readString();
        street = in.readString();
        city = in.readString();
        state = in.readString();
        phone = in.readString();
        email = in.readString();
        age = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(String first, String last, String street, String city, String state, String phone, String email, String age, String imageUrl) {
        this.first = first;
        this.last = last;
        this.street = street;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(first);
        dest.writeString(last);
        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(age);
        dest.writeString(imageUrl);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
