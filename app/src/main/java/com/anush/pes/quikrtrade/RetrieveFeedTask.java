package com.anush.pes.quikrtrade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RetrieveFeedTask {

    private static final String QUIKR_API = "https://api.quikr.com/public/adsByCategory?";

    public static JSONObject getJSON(String cat_id){
        try {
            String url_link = QUIKR_API+cat_id;

            URL url = new URL(url_link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            System.out.println("***URl***"+url_link);
            connection.setRequestMethod("GET");
            System.out.println("###Connection###");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("X-Quikr-App-Id","536");
            connection.setRequestProperty("X-Quikr-Token-Id","3075096");
            connection.setRequestProperty("X-Quikr-Signature","9e31557dcf01d78b7de0af0af7e8bfc4b520af20");
            System.out.println("***Connection***");
            System.out.println("$$$"+connection.getResponseCode());
            connection.connect();
            System.out.println("###Connection###");
            /*
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println("***Connection***");

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            System.out.println("***Actual:"+json.toString());
            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not
            // successful
            if(data.getInt("cod") != 200){
                return null;
            }
            */
            System.out.println("$$$"+connection.getResponseCode());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            System.out.println("$$$Connection$$$");
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject data = new JSONObject(response.toString());
            System.out.println(response.toString());
            return data;
        }catch(Exception e){
            return null;
        }
    }
}
