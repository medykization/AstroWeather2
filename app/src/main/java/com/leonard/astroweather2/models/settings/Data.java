package com.leonard.astroweather2.models.settings;

public class Data {

    private String longitude;
    private String latitude;
    private String name;
    private int delay;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Data{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", name='" + name + '\'' +
                ", delay=" + delay +
                '}';
    }
}
