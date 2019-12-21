import com.google.gson.Gson;

import Object.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JSONParser {

    private ArrayList<PolisenObject> object = new ArrayList<>();

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    public static String jsonGetRequest() {
        //Hämtar JSON som en temporär fil ifrån polisens hemsida.
        String json = null;
        try {
            URL url = new URL("https://polisen.se/api/events");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string

            /* Onödig kod som skriver ner JSON till en lokal fil.
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Olle\\IdeaProjects\\PolisenHandelser\\src\\polisen.json"));
            writer.write(json);
            writer.close();

             */
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }


    public void jsonToObject(){
        //Skapar ett "PolisenObject" av den hämtade temporära JSON-filen.

        String json  = jsonGetRequest();
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            int id = jsonObject.getInt("id");
            String datetime = jsonObject.getString("datetime");
            String name = jsonObject.getString("name");
            String summary = jsonObject.getString("summary");
            String url = jsonObject.getString("url");
            String type = jsonObject.getString("type");

            PolisenObject polisenObject = new PolisenObject(id, datetime, name, summary, url, type);
            System.out.println(polisenObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

