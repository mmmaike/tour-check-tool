package maike.whoisontour.tourcheck;

import java.io.IOException;
import java.util.Properties;

class ApiKeyProvider {

    String getApiKey() {
        Properties properties = new Properties();
        try {
            properties.load(ApiKeyProvider.class.getClassLoader().getResourceAsStream("ticketmaster.properties"));
            String apiKey = properties.getProperty("api.key");

            if (apiKey.isEmpty()) {
                System.out.println("No api key found. Please get one at: https://developer.ticketmaster.com/");
                System.exit(1);
                return "";
            } else {
                return apiKey;
            }
        } catch (IOException e) {
            System.exit(1);
            return "";
        }
    }
}
