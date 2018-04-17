package com.amadeus;

import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import lombok.Getter;

public class Amadeus {
  private final @Getter Configuration configuration;

  public Amadeus(Configuration configuration) {
    this.configuration = configuration;
  }

  public static Configuration builder() {
    return new Configuration();
  }

  public Object post(String path) throws IOException {
    HashMap<String, String> postDataParams = new HashMap<String, String>();
    postDataParams.put("grant_type", "client_credentials");
    postDataParams.put("client_id", this.configuration.getClientId());
    postDataParams.put("client_secret", this.configuration.getClientSecret());

    Gson gson = new Gson();
    String uri = String.format("https://test.api.amadeus.com/%s", path);

    URL url = new URL(uri);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestProperty("Accept", "application/json, application/vnd.amadeus+json");
    connection.setRequestMethod("POST");
    connection.setDoInput(true);
    connection.setDoOutput(true);

    OutputStream os = connection.getOutputStream();
    BufferedWriter writer = new BufferedWriter(
      new OutputStreamWriter(os, "UTF-8"));
    writer.write(getPostDataString(postDataParams));

    writer.flush();
    writer.close();
    os.close();

    int responseCode = connection.getResponseCode();


    System.out.println(responseCode);

    if(responseCode == HttpURLConnection.HTTP_OK){
        BufferedReader in = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();

        Object data = gson.fromJson(response.toString(), Object.class);
        System.out.println(data);
    }
    return null;
  }

  private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
       StringBuilder result = new StringBuilder();
       boolean first = true;
       for(Map.Entry<String, String> entry : params.entrySet()){
           if (first)
               first = false;
           else
               result.append("&");

           result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
           result.append("=");
           result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
       }

       return result.toString();
   }
}
