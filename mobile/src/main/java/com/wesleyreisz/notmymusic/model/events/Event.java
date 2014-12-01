
package com.wesleyreisz.notmymusic.model.events;

import java.util.ArrayList;
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
    "links",
    "id",
    "stats",
    "title",
    "announce_date",
    "score",
    "date_tbd",
    "type",
    "datetime_local",
    "visible_until_utc",
    "time_tbd",
    "taxonomies",
    "performers",
    "url",
    "created_at",
    "venue",
    "short_title",
    "datetime_utc",
    "datetime_tbd"
})
public class Event {

    @JsonProperty("links")
    private List<Object> links = new ArrayList<Object>();
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("title")
    private String title;
    @JsonProperty("announce_date")
    private String announceDate;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("date_tbd")
    private Boolean dateTbd;
    @JsonProperty("type")
    private String type;
    @JsonProperty("datetime_local")
    private String datetimeLocal;
    @JsonProperty("visible_until_utc")
    private String visibleUntilUtc;
    @JsonProperty("time_tbd")
    private Boolean timeTbd;
    @JsonProperty("taxonomies")
    private List<Taxonomy> taxonomies = new ArrayList<Taxonomy>();
    @JsonProperty("performers")
    private List<Performer> performers = new ArrayList<Performer>();
    @JsonProperty("url")
    private String url;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("short_title")
    private String shortTitle;
    @JsonProperty("datetime_utc")
    private String datetimeUtc;
    @JsonProperty("datetime_tbd")
    private Boolean datetimeTbd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The links
     */
    @JsonProperty("links")
    public List<Object> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(List<Object> links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The stats
     */
    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The announceDate
     */
    @JsonProperty("announce_date")
    public String getAnnounceDate() {
        return announceDate;
    }

    /**
     * 
     * @param announceDate
     *     The announce_date
     */
    @JsonProperty("announce_date")
    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    /**
     * 
     * @return
     *     The score
     */
    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The dateTbd
     */
    @JsonProperty("date_tbd")
    public Boolean getDateTbd() {
        return dateTbd;
    }

    /**
     * 
     * @param dateTbd
     *     The date_tbd
     */
    @JsonProperty("date_tbd")
    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The datetimeLocal
     */
    @JsonProperty("datetime_local")
    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    /**
     * 
     * @param datetimeLocal
     *     The datetime_local
     */
    @JsonProperty("datetime_local")
    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
    }

    /**
     * 
     * @return
     *     The visibleUntilUtc
     */
    @JsonProperty("visible_until_utc")
    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    /**
     * 
     * @param visibleUntilUtc
     *     The visible_until_utc
     */
    @JsonProperty("visible_until_utc")
    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    /**
     * 
     * @return
     *     The timeTbd
     */
    @JsonProperty("time_tbd")
    public Boolean getTimeTbd() {
        return timeTbd;
    }

    /**
     * 
     * @param timeTbd
     *     The time_tbd
     */
    @JsonProperty("time_tbd")
    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    /**
     * 
     * @return
     *     The taxonomies
     */
    @JsonProperty("taxonomies")
    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    /**
     * 
     * @param taxonomies
     *     The taxonomies
     */
    @JsonProperty("taxonomies")
    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    /**
     * 
     * @return
     *     The performers
     */
    @JsonProperty("performers")
    public List<Performer> getPerformers() {
        return performers;
    }

    /**
     * 
     * @param performers
     *     The performers
     */
    @JsonProperty("performers")
    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The venue
     */
    @JsonProperty("venue")
    public Venue getVenue() {
        return venue;
    }

    /**
     * 
     * @param venue
     *     The venue
     */
    @JsonProperty("venue")
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * 
     * @return
     *     The shortTitle
     */
    @JsonProperty("short_title")
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * 
     * @param shortTitle
     *     The short_title
     */
    @JsonProperty("short_title")
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * 
     * @return
     *     The datetimeUtc
     */
    @JsonProperty("datetime_utc")
    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    /**
     * 
     * @param datetimeUtc
     *     The datetime_utc
     */
    @JsonProperty("datetime_utc")
    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    /**
     * 
     * @return
     *     The datetimeTbd
     */
    @JsonProperty("datetime_tbd")
    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    /**
     * 
     * @param datetimeTbd
     *     The datetime_tbd
     */
    @JsonProperty("datetime_tbd")
    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
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
