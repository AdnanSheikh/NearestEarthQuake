package com.smartrecruiter.util;

/**
 * Created by Adnan Ahmad on 9/2/2018.
 */
public class DistanceCalculator {

    private static final int EARTH_RADIUS = 6371;

    public static double distance(double startLong, double startLat, double endLong, double endLat) {
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}