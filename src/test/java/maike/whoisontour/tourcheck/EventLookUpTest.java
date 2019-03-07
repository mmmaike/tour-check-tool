package maike.whoisontour.tourcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.Test;

public class EventLookUpTest {

	@Test
	public void buildApiRequest() {
		// given
		ApiKeyProvider apiKeyProvider = mock(ApiKeyProvider.class);
		when(apiKeyProvider.getApiKey()).thenReturn("foo");

		EventLookUp eventLookUp = new EventLookUp(apiKeyProvider);

		// when
		URL result = eventLookUp.buildApiRequest("type", "666", "slayer");

		// then
		assertThat(result.toString()).isEqualTo("https://app.ticketmaster.com/discovery/v2/type?apikey=foo&attractionId=666&countryCode=DE");
	}
}
