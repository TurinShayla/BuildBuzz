package com.example.buildbuzz;

import android.widget.DatePicker;

public class Site {
    private String name;
    private String location;
    private String tentativeDate;
    private String roadClosed;
    private String type;
    private String photos;
    private String userKey;
public Site(){

}

    public Site(String name, String location, String tentativeDate, String roadClosed, String type, String photos, String userKey) {
        this.name = name;
        this.location = location;
        this.tentativeDate = tentativeDate;
        this.roadClosed = roadClosed;
        this.type = type;
        this.photos = photos;
        this.userKey = userKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTentativeDate() {
        return tentativeDate;
    }

    public void setTentativeDate(String tentativeDate) {
        this.tentativeDate = tentativeDate;
    }

    public String getRoadClosed() {
        return roadClosed;
    }

    public void setRoadClosed(String roadClosed) {
        this.roadClosed = roadClosed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
