
package maike.whoisontour.tourcheck.ticketmasterapi.datamodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "wiki",
    "musicbrainz"
})
public class ExternalLinks {

    @JsonProperty("wiki")
    private List<Wiki> wiki = null;
    @JsonProperty("musicbrainz")
    private List<Musicbrainz> musicbrainz = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("wiki")
    public List<Wiki> getWiki() {
        return wiki;
    }

    @JsonProperty("wiki")
    public void setWiki(List<Wiki> wiki) {
        this.wiki = wiki;
    }

    @JsonProperty("musicbrainz")
    public List<Musicbrainz> getMusicbrainz() {
        return musicbrainz;
    }

    @JsonProperty("musicbrainz")
    public void setMusicbrainz(List<Musicbrainz> musicbrainz) {
        this.musicbrainz = musicbrainz;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
