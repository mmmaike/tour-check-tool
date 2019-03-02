package maike.whoisontour.tourcheck;

import maike.whoisontour.tourcheck.ticketmasterapi.datamodel.Artist;

public class TourCheckMain {
    public static void main(String[] args) {
        String artist = InputHandler.getArtist();
        EventLookUp lookUp = new EventLookUp();
        Artist foundArtist = lookUp.findArtistID(artist);
        lookUp.lookUpEvents(foundArtist.getName(), foundArtist.getId());
    }
}
