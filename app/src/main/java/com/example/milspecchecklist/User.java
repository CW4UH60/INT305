package com.example.milspecchecklist;

public class User {

    String name, subDetails, itemDate, listDetails, country;
    int imageId;

    public User(String name, String subDetails, String itemDate, String listDetails, String country, int imageId) {
        this.name = name;
        this.subDetails = subDetails;
        this.itemDate = itemDate;
        this.listDetails = listDetails;
        this.country = country;
        this.imageId = imageId;
    }
}
