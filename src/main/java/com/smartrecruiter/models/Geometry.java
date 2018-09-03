package com.smartrecruiter.models;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adnan Ahmad on 9/2/2018.
 */

@Data
@ToString
public class Geometry {

    private String type;
    private List<Double> coordinates = null;
    private Map<String, Object> additionalProperties = new HashMap<>();

}