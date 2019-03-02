package maike.whoisontour.tourcheck;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import maike.whoisontour.tourcheck.ticketmasterapi.datamodel.Artist;
import maike.whoisontour.tourcheck.ticketmasterapi.datamodel.AttractionResponse;
import maike.whoisontour.tourcheck.ticketmasterapi.datamodel.Event;
import maike.whoisontour.tourcheck.ticketmasterapi.datamodel.EventResponse;

public class EventLookUp {
    private static final String apiKey = "<YOUR_API_KEY>";
    private static final String baseURL = "https://app.ticketmaster.com/discovery/v2/";
    private static final String keyPrefix = "?apikey=";
    private static final String countryCode = "&countryCode=DE";
    private static final String events = "events";
    private static final String attractions = "attractions";
    private static final String attractionIdPrefix = "&attractionId=";
    private static final String keyword = "&keyword=";

    private static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private URL buildApiRequest(String type, String artistID, String artistName) {
        URL url = null;
        String urlString = baseURL + type + keyPrefix + apiKey;
        if (artistID != null) {
            urlString += attractionIdPrefix + artistID + countryCode;
        }
        if (type.equals(attractions)) {
            urlString += keyword + artistName;
        }

        try {
            url = new URL(urlString);
            System.out.println(url);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }


    public void lookUpEvents(String artistName, String artistID) {

        URL url = buildApiRequest(events, artistID, artistName);
        try {
            EventResponse response = mapper.readValue(url, EventResponse.class);
            if (response.getEmbedded() == null) {
                System.out.println("No upcoming events for " + artistName);
                return;
            }

            System.out.println("Events for " + artistName + " in Germany:");

            for (Event event : response.getEmbedded().getEvents()) {
                System.out.println(event.getEmbedded().getVenues().get(0).getCity().getName() + " on "
                        + event.getDates().getStart().getLocalDate());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Artist findArtistID(String artist) {
        URL url = null;
        Artist relevantArtist = null;
        try {
            url = buildApiRequest(attractions, null, artist);

            AttractionResponse response = mapper.readValue(url, AttractionResponse.class);
            if (response.getEmbedded() == null) {
                System.out.println("Artist not found");
                return null;
            }


            relevantArtist = new Artist(response.getEmbedded().getAttractions().get(0).getName(),
                    response.getEmbedded().getAttractions().get(0).getId());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return relevantArtist;
    }
}
