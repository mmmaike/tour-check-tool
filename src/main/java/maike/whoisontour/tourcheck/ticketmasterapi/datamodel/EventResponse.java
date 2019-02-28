
package maike.whoisontour.tourcheck.ticketmasterapi.datamodel;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_embedded",
    "_links",
    "page"
})
public class EventResponse {

    @JsonProperty("_embedded")
    private EmbeddedEvents embedded;
    @JsonProperty("_links")
    private Links___ links;
    @JsonProperty("page")
    private Page page;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_embedded")
    public EmbeddedEvents getEmbedded() {
        return embedded;
    }

    @JsonProperty("_embedded")
    public void setEmbedded(EmbeddedEvents embedded) {
        this.embedded = embedded;
    }

    @JsonProperty("_links")
    public Links___ getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links___ links) {
        this.links = links;
    }

    @JsonProperty("page")
    public Page getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Page page) {
        this.page = page;
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
