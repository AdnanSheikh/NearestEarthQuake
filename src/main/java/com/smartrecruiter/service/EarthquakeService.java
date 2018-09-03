package com.smartrecruiter.service;

import com.smartrecruiter.models.Result;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Adnan Ahmad on 9/2/2018.
 */
@Service
public class EarthquakeService {

    private final String LAST_30_DAYS_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";

    private final RestTemplate restTemplate;

    public EarthquakeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Result getLast30daysEarthquake() {
        return this.restTemplate.getForObject(LAST_30_DAYS_URL, Result.class);
    }
}