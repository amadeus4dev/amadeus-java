package com.amadeus;

import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Amadeus {
  public Object test() throws IOException {
    Gson gson = new Gson();
    String uri = "http://json-gen.com/rest/service/get/vpMW0my7SXDmOmTNu795zDeJRn";

    URL url = new URL(uri);
	  HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    int responseCode = connection.getResponseCode();

    if(responseCode == 200){
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
}
