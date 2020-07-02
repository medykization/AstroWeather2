package com.leonard.astroweather2.models.astro_info;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

import java.util.Calendar;

public class Info {

    private AstroCalculator calculator;
    private double longitude, latitude;

    public Info(String longitude, String latitude) {
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
        initCalculator();
    }

    private void initCalculator () {
        this.calculator = new AstroCalculator(getDate(),new AstroCalculator.Location(latitude,longitude));
    }

    private AstroDateTime getDate() {
        Calendar calendar = Calendar.getInstance();
        return new AstroDateTime(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), calendar.get(Calendar.ZONE_OFFSET),  true);
    }

    public AstroCalculator.SunInfo getSunInfo() {
        initCalculator();
        return calculator.getSunInfo();
    }

    public AstroCalculator.MoonInfo getMoonInfo() {
        initCalculator();
        return calculator.getMoonInfo();
    }
}
