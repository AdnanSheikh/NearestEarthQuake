package com.smartrecruiter.processor;

import com.smartrecruiter.models.ClosestEarthQuake;
import com.smartrecruiter.models.Feature;
import com.smartrecruiter.models.Result;
import com.smartrecruiter.service.EarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import static com.smartrecruiter.util.DistanceCalculator.distance;

/**
 * Created by Adnan Ahmad on 9/2/2018.
 */
@Component
public class RequestProcessor {

    @Autowired
    private EarthquakeService service;

    public void findClosestEarthQuake(final double longitude, final double latitude, final int noOfClosest){
        Result result = service.getLast30daysEarthquake();
        List<ClosestEarthQuake> closestList = result.getFeatures().stream()
                                                   .filter(distinctByCoordinate(f -> Pair.of(getLongitude(f), getLatitude(f))))
                                                   .map(f -> new ClosestEarthQuake(
                                                           f.getProperties().getTitle(),
                                                           distance(longitude, latitude, getLongitude(f), getLatitude(f))
                                                   ))
                                                   .sorted(Comparator.comparing(ClosestEarthQuake::getDistance))
                                                   .limit(noOfClosest)
                                                   .collect(Collectors.toList());

        System.out.printf("Count: %d\n", closestList.size());
        closestList.stream().forEach(System.out::println);

    }

    private <T> Predicate<T> distinctByCoordinate(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private double getLongitude(final Feature feature){
        return feature.getGeometry().getCoordinates().get(0);
    }

    private double getLatitude(final Feature feature){
        return feature.getGeometry().getCoordinates().get(1);
    }
}