
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
    "tmr",
    "ticketmaster"
})
public class UpcomingEvents {

    @JsonProperty("_total")
    private Integer total;
    @JsonProperty("tmr")
    private Integer tmr;
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

    @JsonProperty("tmr")
    public Integer getTmr() {
        return tmr;
    }

    @JsonProperty("tmr")
    public void setTmr(Integer tmr) {
        this.tmr = tmr;
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
