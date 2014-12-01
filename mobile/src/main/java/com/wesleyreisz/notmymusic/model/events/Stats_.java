
package com.wesleyreisz.notmymusic.model.events;

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
    "event_count"
})
public class Stats_ {

    @JsonProperty("event_count")
    private Integer eventCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The eventCount
     */
    @JsonProperty("event_count")
    public Integer getEventCount() {
        return eventCount;
    }

    /**
     * 
     * @param eventCount
     *     The event_count
     */
    @JsonProperty("event_count")
    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
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
