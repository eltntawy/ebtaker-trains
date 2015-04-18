/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iti.request;

import com.iti.pojo.City;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author yomna
 */
public class NearbyService {
    
    public static List getNearbyHospital(String x, String y,String r) throws IOException {
        
    	String type = "food";
        return getNearby(x, y, r, type);
       
    }

    public static Location getLocation(String to) throws IOException {
        String url = "https://developer.vodafone.com.eg/api/c9962c59e59066b470d86fd1f9b6053d/LocationAPI/getLocation?shortCode=50020&to=" + to;

//        String result = httpGet(url);

//        System.out.println(result);
//        Object obj = JSONValue.parse(result.toString());
//        JSONObject jsonObj = (JSONObject) obj;
//        String resultCode = (String) jsonObj.get("result");
//        String xCord = (String) jsonObj.get("xCord");
//        String yCord = (String) jsonObj.get("yCord");
//        String radius = (String) jsonObj.get("radius");



        //Location location = new Location(xCord,yCord,radius);
        //Location location = new Location("30.079189","31.014934","10000"); // ITI
        Location location = new Location("40.851394","-93.260018","10000");

        return location;
    }
    
    public static List<Address> getNearby(String x, String y,String r,String type) throws IOException {
        
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?v=3&location=";
        url = url.concat(x);
        url = url.concat("%2C");
        url = url.concat(y);
        url = url.concat("&radius=");
        url = url.concat(r);
        url = url.concat("&types=");
        url = url.concat(type);
        url = url.concat("&key=AIzaSyAmsScw_ynzyQf32_KSGjbGiej7VN2rL7g");

        String result = httpGet(url);

        Object obj = JSONValue.parse(result.toString());
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray resultsArray = (JSONArray) jsonObj.get("results");
        Iterator i = resultsArray.iterator();

        ArrayList<Address> addresses = new ArrayList<Address>();

        while (i.hasNext()) {

            JSONObject jsonResult = (JSONObject) i.next();
            String name = (String) jsonResult.get("name");
            String vicinity = (String) jsonResult.get("vicinity");

            System.out.println(name);

            Address address = new Address();
            address.setName(name);
            address.setVicinity(vicinity);

            addresses.add(address);

        }

        return addresses;
    }


    public static String httpGet(String url) throws IOException {
        //connect to url
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);

        HttpResponse response;


        response = client.execute(get);

        InputStream in = response.getEntity().getContent();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }


        return result.toString();
    }

    public static List<String> getTrains(City from, City to){



        Map<String,List<City>> trainsSchedule = getTrainsSchedule();
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, List<City>> train : trainsSchedule.entrySet()) {
            int fromIndex = train.getValue().indexOf(from);
            int toIndex = train.getValue().indexOf(to);

            if (fromIndex == -1 || toIndex == -1) {
                continue;
            } else if (fromIndex >= toIndex) {
                continue;
            } else {
                result.add(train.getKey() + " " + train.getValue().get(fromIndex).getTime());
            }
        }

        return result;
    }

    public static Map<String,List<City>> getTrainsSchedule(){

        City Cairo = new City("1", "القاهرة", "01:00");
        City Alex = new City("2", "الاسكندرية,", "02:00");
        City Asiut = new City("3", "أسيوط", "04:00");
        City Ismailia = new City("4", "الاسماعيلية", "06:00");
        City Luxor = new City("5", "الأقصر", "12:00");
        City Giza = new City("6", "الجيزة", "15:00");
        City Banha = new City("7", "بنها", "16:00");
        City Swaif = new City("8", "بني سويف", "23:00");
        City Kena = new City("9", "قنا", "11:00");
        City Tanta = new City("10", "طنطا", "10:00");

        Map<String, List<City>> trains = new HashMap<>();
        trains.put("587", Arrays.asList(new City[]{Alex, Cairo, Asiut}));
        trains.put("123", Arrays.asList(new City[]{Alex, Tanta, Cairo, Ismailia, Kena}));
        trains.put("789", Arrays.asList(new City[]{Giza, Banha, Swaif, Luxor}));
        trains.put("105", Arrays.asList(new City[]{Luxor, Asiut, Kena, Cairo, Tanta, Alex}));

        return trains;
    }

}
