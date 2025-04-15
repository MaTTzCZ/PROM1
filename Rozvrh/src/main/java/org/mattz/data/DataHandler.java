package org.mattz.data;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DataHandler {
    URL url;


    private String[] rooms = {
            "J1",
            "J2",
            "J3",
            "J4",
            "J5",
            "J6",
            "J7",
            "J8",
            "J9",
            "J10",
            "J11",
            "J12",
            "J13",
            "J14",
            "J15",
            "J16",
            "J17",
            "J18",
            "J20",
            "J21",
            "J22",
            "J23",
            "J24",
            "J25",
            "J26",
            "J27",
            "J28",
            "J30",
            "J31"
    };

    public DataHandler() {
    }

    public String[] getRooms() {
        return rooms;
    }

    public String[] getRoomData(String selectedFaculty, String selectedRoom) {
        try {
            url = new URI("https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByMistnost?semestr=%25&budova=" + selectedFaculty + "&mistnost=" + selectedRoom + "&outputFormat=JSON").toURL();
            InputStream stream = (InputStream) url.getContent();
            System.out.println(new String(stream.readAllBytes(), StandardCharsets.UTF_8));
        } catch (URISyntaxException | IOException e) {
            return null;
        }
        return new String[] {url.toString()};
    }
}

