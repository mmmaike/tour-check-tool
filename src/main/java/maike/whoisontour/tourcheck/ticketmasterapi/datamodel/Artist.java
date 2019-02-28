package maike.whoisontour.tourcheck.ticketmasterapi.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
	
	@JsonProperty("name")
	private String name;
		
	@JsonProperty("id")
	private String id;
	
	public Artist(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
