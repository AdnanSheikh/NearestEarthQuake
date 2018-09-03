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
public class Properties {

    private Double mag;
    private String place;
    private Long time;
    private Long updated;
    private Integer tz;
    private String url;
    private String detail;
    private Object felt;
    private Object cdi;
    private Object mmi;
    private Object alert;
    private String status;
    private Integer tsunami;
    private Integer sig;
    private String net;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private Object nst;
    private Double dmin;
    private Double rms;
    private Integer gap;
    private String magType;
    private String type;
    private String title;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}