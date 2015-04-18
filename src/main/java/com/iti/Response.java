package com.iti;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by eltntawy on 17/04/15.
 */
public class Response {

    public static final int RESPONSE_CODE_OK = 0;
    public static final int RESPONSE_CODE_INVALID = 1;
    public static final int RESPONSE_CODE_ERROR = 2;

    public static final String SESSION_OPERATION_NEW = "new";
    public static final String SESSION_OPERATION_CONTINUE = "continue";
    public static final String SESSION_OPERATION_END = "end";

    private String result="";    //Result code as defined in response codes table
    private String text="";    //Response text, which should be sent back to the mobile user.
    private String sessionOperation="";    //Operation, which indicates if the session status. Supported values: continue, end.
    private String screenId=""; //  Unique screen ID provided by the partner that identifies each screen. This value will be sent in the next request to the partner.


    public Response() {
    }

    public Response( String sessionOperation, String screenId) {
        this.sessionOperation = sessionOperation;
        this.screenId = screenId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSessionOperation() {
        return sessionOperation;
    }

    public void setSessionOperation(String sessionOperation) {
        this.sessionOperation = sessionOperation;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public void createTypeScreen() {

        StringBuilder str = new StringBuilder();
        Map<Integer,String> typeList =   ServiceType.getServiceType();
        str.append("Please select service type ");
        for(int i = 1 ; i <= typeList.size() ; i++ ) {
            str.append(i + ":"+typeList.get(i)+" ");
        }

        setText(str.toString());
    }


    public void createCitiesScreen(String fromOrTo) {

        StringBuilder str = new StringBuilder();
        Map<String,String> cityList =   ServiceType.getCities();
        str.append("Please select city "+fromOrTo);
        Set<String> keies = cityList.keySet();
        Iterator<String > iterator = keies.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            String city = cityList.get(key);
            str.append(key + ":"+city+" ");
        }

        setText(str.toString());
    }


    @Override
    public String toString() {
        String retResult = "" +
                "{" +
                "\"result\":\""+RESPONSE_CODE_OK+"\"," +
                "\"text\":\""+text+"\"," +
                "\"sessionOperation\":\""+sessionOperation+"\"," +
                "\"screenId\":\""+screenId+"\"" +
                "}";
        return retResult;
    }
}
