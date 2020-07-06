package com.leonard.astroweather2.models.settings;

public class City {

    private String name;
    private int visibility;
    private int windDirection;
    private int id;
    private int humidity; // wilgotność
    private double windSpeed;
    private int pressure;
    private String longitude;
    private String latitude;

    public City() {}

    public City(String name, int windDirection, int visibility, int id, int humidity, double windSpeed, int pressure, String longitude, String latitude) {
        this.name = name;
        this.windDirection = windDirection;
        this.visibility = visibility;
        this.id = id;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.longitude = longitude;
        this.latitude = latitude;
    }

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

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getVisibility() {
        return visibility;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", visibility=" + visibility +
                ", windDirection=" + windDirection +
                ", id=" + id +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
