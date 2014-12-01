
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
    "listing_count",
    "average_price",
    "lowest_price",
    "highest_price"
})
public class Stats {

    @JsonProperty("listing_count")
    private Integer listingCount;
    @JsonProperty("average_price")
    private Double averagePrice;
    @JsonProperty("lowest_price")
    private Double lowestPrice;
    @JsonProperty("highest_price")
    private Double highestPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The listingCount
     */
    @JsonProperty("listing_count")
    public Integer getListingCount() {
        return listingCount;
    }

    /**
     * 
     * @param listingCount
     *     The listing_count
     */
    @JsonProperty("listing_count")
    public void setListingCount(Integer listingCount) {
        this.listingCount = listingCount;
    }

    /**
     * 
     * @return
     *     The averagePrice
     */
    @JsonProperty("average_price")
    public Double getAveragePrice() {
        return averagePrice;
    }

    /**
     * 
     * @param averagePrice
     *     The average_price
     */
    @JsonProperty("average_price")
    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * 
     * @return
     *     The lowestPrice
     */
    @JsonProperty("lowest_price")
    public Double getLowestPrice() {
        return lowestPrice;
    }

    /**
     * 
     * @param lowestPrice
     *     The lowest_price
     */
    @JsonProperty("lowest_price")
    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * 
     * @return
     *     The highestPrice
     */
    @JsonProperty("highest_price")
    public Double getHighestPrice() {
        return highestPrice;
    }

    /**
     * 
     * @param highestPrice
     *     The highest_price
     */
    @JsonProperty("highest_price")
    public void setHighestPrice(Double highestPrice) {
        this.highestPrice = highestPrice;
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
