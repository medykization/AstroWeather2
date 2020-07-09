package com.leonard.astroweather2.models.data_models;

public class City {

    private String name;
    private int visibility;
    private int windDirection;
    private int id;
    private int humidity; // wilgotność
    private double windSpeed;
    private double temp;
    private int pressure;
    private String longitude;
    private String latitude;
    private int delay;

    public City() {}

    public City(String name, int visibility, int windDirection, int id, int humidity, double windSpeed, double temp, int pressure, String longitude, String latitude) {
        this.name = name;
        this.visibility = visibility;
        this.windDirection = windDirection;
        this.id = id;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.temp = temp;
        this.pressure = pressure;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
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

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", visibility=" + visibility +
                ", windDirection=" + windDirection +
                ", id=" + id +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
