package com.iti;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by eltntawy on 17/04/15.
 */
public class ServiceType {
    public static final String TYPE_FOOD = "food";
    public static final String TYPE_embassy = "embassy";
    public static final String TYPE_pharmacy = "pharmacy";
    public static final String TYPE_gas_station = "gas_station";
    public static final String TYPE_book_store = "book_store";
    public static final String TYPE_cafe = "cafe";
    public static final String TYPE_doctor = "doctor";
    public static final String TYPE_movie_theater = "movie_theater";
    public static final String TYPE_hospital = "hospital";
    public static final String TYPE_health = "health";
    public static final String TYPE_gym = "gym";
    public static final String TYPE_police = "police";
    public static final String TYPE_train_station = "train_station";

    private static Map<Integer, String> map = new TreeMap<Integer, String>();


    public static Map<Integer, String> getServiceType() {
        map.put(1, TYPE_FOOD);
        map.put(2, TYPE_embassy);
        map.put(3, TYPE_pharmacy);
        map.put(4, TYPE_gas_station);
        map.put(5, TYPE_book_store);
        map.put(6, TYPE_cafe);
        map.put(7, TYPE_doctor);
        map.put(8, TYPE_movie_theater);
        map.put(9, TYPE_hospital);
        map.put(10, TYPE_health);
        map.put(11, TYPE_gym);
        map.put(12, TYPE_police);
        map.put(13, TYPE_train_station);


        return map;
    }

    public static String getServiceType(int key) {
        return map.get(key);
    }


    private static Map<String, String> cities = new TreeMap<String, String>();

    public static Map<String,String> getCities() {
        cities.put("1", "Cairo");
        cities.put("2", "Alex");
        cities.put("3", "Asiut");
        cities.put("4", "Ismailia");
        cities.put("5", "Luxor");
        cities.put("6", "Giza");
        cities.put("7", "Banha");
        cities.put("8", "Bani Swaif");
        cities.put("9", "Kena");
        cities.put("10", "Tanta");

        return cities;
    }

    public static String getCity(String key) {
        return cities.get(key);
    }
}
