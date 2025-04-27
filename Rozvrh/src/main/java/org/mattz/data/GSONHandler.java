package org.mattz.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;


public class GSONHandler {
    public GSONHandler() {
    }

    private String getJSON(String targetURL) {
        try {
            URL URL = URI.create(targetURL).toURL();
            HttpURLConnection connection = (HttpURLConnection) URL.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            bufferedReader.close();
            return response.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<String> getBudovy() {
        String JSON = getJSON("https://stagws.uhk.cz/ws/services/rest2/mistnost/getBudovy?outputFormat=json");
        if (JSON == null) return null;
        ArrayList<String> budovy = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(JSON).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("items");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject budova = jsonArray.get(i).getAsJsonObject();
            String zkrBudovy = budova.get("zkrBudovy").getAsString();
            if (zkrBudovy.matches("^[A-Z]+$")) budovy.add(zkrBudovy);
        }
        return budovy;
    }


    public ArrayList<String> getMistnosti(String zkrBudovy) {
        String JSON = getJSON("https://stagws.uhk.cz/ws/services/rest2/mistnost/getMistnostiInfo?zkrBudovy=" + zkrBudovy + "&typ=U&jenPlatne=true&outputFormat=JSON");
        if (JSON == null) return null;
        ArrayList<String> mistnosti = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(JSON).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("mistnostInfo");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject mistnost = jsonArray.get(i).getAsJsonObject();
            String cisloMistnosti = mistnost.get("cisloMistnosti").getAsString();
            mistnosti.add(cisloMistnosti);
        }
        mistnosti.sort((s1, s2) -> {
            String num1 = s1.replaceAll("\\D+", "");
            String num2 = s2.replaceAll("\\D+", "");

            try {
                return Integer.compare(
                        num1.isEmpty() ? 0 : Integer.parseInt(num1),
                        num2.isEmpty() ? 0 : Integer.parseInt(num2)
                );
            } catch (NumberFormatException e) {
                return s1.compareTo(s2);
            }
        });

        return mistnosti;
    }

    public ArrayList<Predmet> getPredmety(String budova, String mistnost, String semestr) {
        String JSON = getJSON("https://stagws.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByMistnost?budova=" + budova + "&mistnost=" + mistnost + "&semestr=" + semestr + "&outputFormat=JSON");
        if (JSON == null) return null;
        ArrayList<Predmet> predmety = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(JSON).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("rozvrhovaAkce");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject mistnostJSONObject = jsonArray.get(i).getAsJsonObject();
            String nazev = mistnostJSONObject.get("nazev").getAsString();
            String predmet = mistnostJSONObject.get("predmet").getAsString();
            String den = mistnostJSONObject.get("den").getAsString();
            String hodinaSkutOd = mistnostJSONObject.getAsJsonObject("hodinaSkutOd").get("value").getAsString();
            String hodinaSkutDo = mistnostJSONObject.getAsJsonObject("hodinaSkutDo").get("value").getAsString();
            String vsichniUciteleJmenaTituly = mistnostJSONObject.get("vsichniUciteleJmenaTituly").getAsString();
            Predmet newPredmet = new Predmet(nazev, predmet, den, hodinaSkutOd, hodinaSkutDo, vsichniUciteleJmenaTituly);
            predmety.add(newPredmet);
        }
        return predmety;
    }
}
