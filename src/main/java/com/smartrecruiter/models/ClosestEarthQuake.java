package com.smartrecruiter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.math3.util.Precision;

import static java.lang.Math.PI;
import static org.apache.commons.math3.util.Precision.round;

/**
 * Created by Adnan Ahmad on 9/2/2018.
 */
@Data
@AllArgsConstructor
public class ClosestEarthQuake {

    private String title;
    private double distance;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(title);
        builder.append(" || ").append(round(distance, 3));
        return builder.toString();
    }
}