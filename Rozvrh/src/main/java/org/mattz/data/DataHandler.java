package org.mattz.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.*;


public class DataHandler {
    URL url;

    public DataHandler() {
    }

    public Mistnost[] getMistnosti(String fakulta){
        try {
            String apiURL = "https://stag-demo.uhk.cz/ws/services/rest2/mistnost/getMistnostiInfo?outputFormat=JSON";
            URL url = new URI(apiURL).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            JsonElement root = JsonParser.parseReader(new InputStreamReader(conn.getInputStream()));
            JsonArray allRooms = root.getAsJsonObject().getAsJsonArray("mistnostInfo");
            System.out.println(allRooms);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String[] geMistnostData(String fakulta, String mistnost) {
        try {
            String wantedURL = String.format(
                    "https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByMistnost?semestr=%%25&budova=%s&mistnost=%s&outputFormat=JSON",
                    fakulta,
                    mistnost
            );
            url = new URI(wantedURL).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

