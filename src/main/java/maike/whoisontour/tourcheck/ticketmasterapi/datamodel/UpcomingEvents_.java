
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
    "_total",
    "mfx-nl",
    "mfx-de",
    "ticketmaster"
})
public class UpcomingEvents_ {

    @JsonProperty("_total")
    private Integer total;
    @JsonProperty("mfx-nl")
    private Integer mfxNl;
    @JsonProperty("mfx-de")
    private Integer mfxDe;
    @JsonProperty("ticketmaster")
    private Integer ticketmaster;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("_total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("mfx-nl")
    public Integer getMfxNl() {
        return mfxNl;
    }

    @JsonProperty("mfx-nl")
    public void setMfxNl(Integer mfxNl) {
        this.mfxNl = mfxNl;
    }

    @JsonProperty("mfx-de")
    public Integer getMfxDe() {
        return mfxDe;
    }

    @JsonProperty("mfx-de")
    public void setMfxDe(Integer mfxDe) {
        this.mfxDe = mfxDe;
    }

    @JsonProperty("ticketmaster")
    public Integer getTicketmaster() {
        return ticketmaster;
    }

    @JsonProperty("ticketmaster")
    public void setTicketmaster(Integer ticketmaster) {
        this.ticketmaster = ticketmaster;
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
