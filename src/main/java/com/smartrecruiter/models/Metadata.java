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
public class Metadata {

    private Long generated;
    private String url;
    private String title;
    private Integer status;
    private String api;
    private Integer count;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}