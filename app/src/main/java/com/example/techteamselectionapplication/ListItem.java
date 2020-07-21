package com.example.techteamselectionapplication;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;

public class ListItem {

    private String image;
    private SpannableString date;
    private String name;
    private String venue;
    private String price;

    public ListItem(String image, SpannableString date, String name, String venue, String price) {
        this.image = image;
        this.date = date;
        this.name = name;
        this.venue = venue;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SpannableString getDate() {
        this.date.setSpan(new AbsoluteSizeSpan(60), 4, 6, 0);
        return date;
    }

    public void setDate(SpannableString date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
