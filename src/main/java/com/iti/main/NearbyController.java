package com.iti.main;

import com.iti.Response;
import com.iti.ServiceType;
import com.iti.pojo.City;
import com.iti.request.NearbyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class NearbyController {

    public static Map<String,Data> sessionManager= new HashMap<String,Data>();

    @RequestMapping(method = RequestMethod.GET)
    public String getScreen(
            @RequestParam(value = "shortCode", required = false) String shortCode,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "sessionOperation", required = false) String sessionOperation,
            @RequestParam(value = "screenId", required = false) String screenId,
            @RequestParam(value = "sessionId", required = false) String sessionId,
            @RequestParam(value = "event", required = false) String event) {

        System.err.println("shortCode : " + shortCode);
        System.err.println("from : " + from);
        System.err.println("text : " + text);
        System.err.println("sessionOperation : " + sessionOperation);
        System.err.println("screenId : " + screenId);
        System.err.println("sessionId : " + sessionId);
        System.err.println("event : " + event);


        Response response = new Response();

        if (screenId != null) {

            Data data ;
            switch (screenId) {
                case "":
                    sessionManager.put(sessionId,new Data());
                    response.setResult("0");
                    response.createCitiesScreen("from");
                    response.setScreenId("1");
                    response.setSessionOperation(Response.SESSION_OPERATION_CONTINUE);
                    break;
                case "1":
                     data = sessionManager.get(sessionId);

                    data.setFrom(new City(text,ServiceType.getCity(text)));

                    response.setResult("0");
                    response.createCitiesScreen("to");
                    response.setScreenId("2");
                    response.setSessionOperation(Response.SESSION_OPERATION_CONTINUE);
                    break;
                case "2":
                    data = sessionManager.get(sessionId);

                    data.setTo(new City(text,ServiceType.getCity(text)));

                    List<String> trains= NearbyService.getTrains(data.getFrom(),data.getTo());
                    StringBuilder stringBuilder = new StringBuilder();
                    for(String train : trains) {
                        stringBuilder.append(train+" - ");
                    }

                    response.setText(stringBuilder.toString());

                    response.setResult("0");
                    response.setSessionOperation(Response.SESSION_OPERATION_END);
                    break;
                default:
                    response.setText("error session is invalid : " + sessionOperation);
                    response.setSessionOperation(null);
                    break;
            }

            return response.toString();
        } else {
            response.setResult("1");
            response.setText("error parameter error");
            response.setSessionOperation(Response.SESSION_OPERATION_END);
        }

        return response.toString();
    }


}


class Data {
    private City from;
    private City to;

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }
}