package maike.whoisontour.tourcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.Test;

public class TicketMasterClientTest {

	private ApiKeyProvider apiKeyProvider = mock(ApiKeyProvider.class);

	// FIXME I find it hard to find the differences between the parameterized buildApiRequest() invocations
	// how about removing the logic from that method and instead make it two methods:
	// one to find the id and one for the querying of upcoming events?

	@Test
	public void buildsUrl() {
		// given
		when(apiKeyProvider.getApiKey()).thenReturn("foo");

		TicketMasterClient ticketMasterClient = new TicketMasterClient(apiKeyProvider);

		// when
		URL result = ticketMasterClient.buildApiRequest("type", "666", "slayer");

		// then
		assertThat(result.toString()).isEqualTo("https://app.ticketmaster.com/discovery/v2/type?apikey=foo&attractionId=666&countryCode=DE");
	}

	@Test
	public void buildsUrlForAttractionsCorrectly() {
		// given
		when(apiKeyProvider.getApiKey()).thenReturn("foo");

		TicketMasterClient ticketMasterClient = new TicketMasterClient(apiKeyProvider);

		// when
		URL result = ticketMasterClient.buildApiRequest("attractions", "666", "slayer");

		// then
		assertThat(result.toString()).isEqualTo("https://app.ticketmaster.com/discovery/v2/attractions?apikey=foo&attractionId=666&countryCode=DE&keyword=slayer");
	}

	// TODO mmmaike
	@Test
	public void encodesGermanUmalautsCorrectly() {
		// given
		when(apiKeyProvider.getApiKey()).thenReturn("foo");

		TicketMasterClient ticketMasterClient = new TicketMasterClient(apiKeyProvider);

		// when
		URL result = ticketMasterClient.buildApiRequest("attractions", "666", "släyer");

		// then
		assertThat(result.toString()).isEqualTo("https://app.ticketmaster.com/discovery/v2/attractions?apikey=foo&attractionId=666&countryCode=DE&keyword=sl%C3%A4yer");
	}



}
