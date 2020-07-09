package com.leonard.astroweather2.models.data_models;

public class DayInfo {
    private String name;
    private String date;
    private String weather;
    private Double temp;
    private Double pressure;
    private Double humidity;

    public DayInfo() {}

    public DayInfo(String name, String date, String weather, Double temp, Double pressure, Double humidity) {
        this.name = name;
        this.date = date;
        this.weather = weather;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}
