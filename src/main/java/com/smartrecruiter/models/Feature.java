package com.smartrecruiter.models;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adnan Ahmad on 9/2/2018.
 */

@Data
@ToString
public class Feature {

    private String type;
    private Properties properties;
    private Geometry geometry;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<>();

}