
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
    "per_page",
    "total",
    "geolocation",
    "took",
    "page"
})
public class Meta {

    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("geolocation")
    private Object geolocation;
    @JsonProperty("took")
    private Integer took;
    @JsonProperty("page")
    private Integer page;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The perPage
     */
    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    /**
     * 
     * @param perPage
     *     The per_page
     */
    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The geolocation
     */
    @JsonProperty("geolocation")
    public Object getGeolocation() {
        return geolocation;
    }

    /**
     * 
     * @param geolocation
     *     The geolocation
     */
    @JsonProperty("geolocation")
    public void setGeolocation(Object geolocation) {
        this.geolocation = geolocation;
    }

    /**
     * 
     * @return
     *     The took
     */
    @JsonProperty("took")
    public Integer getTook() {
        return took;
    }

    /**
     * 
     * @param took
     *     The took
     */
    @JsonProperty("took")
    public void setTook(Integer took) {
        this.took = took;
    }

    /**
     * 
     * @return
     *     The page
     */
    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    @JsonProperty("page")
    public void setPage(Integer page) {
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
