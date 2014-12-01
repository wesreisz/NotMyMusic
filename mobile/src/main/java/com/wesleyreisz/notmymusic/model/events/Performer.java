
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
    "stats",
    "name",
    "short_name",
    "url",
    "type",
    "image",
    "home_venue_id",
    "slug",
    "score",
    "images",
    "taxonomies",
    "has_upcoming_events",
    "id",
    "genres",
    "primary"
})
public class Performer {

    @JsonProperty("stats")
    private Stats_ stats;
    @JsonProperty("name")
    private String name;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("image")
    private Object image;
    @JsonProperty("home_venue_id")
    private Object homeVenueId;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("taxonomies")
    private List<Taxonomy_> taxonomies = new ArrayList<Taxonomy_>();
    @JsonProperty("has_upcoming_events")
    private Boolean hasUpcomingEvents;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("genres")
    private List<Genre> genres = new ArrayList<Genre>();
    @JsonProperty("primary")
    private Boolean primary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The stats
     */
    @JsonProperty("stats")
    public Stats_ getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    @JsonProperty("stats")
    public void setStats(Stats_ stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The shortName
     */
    @JsonProperty("short_name")
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The short_name
     */
    @JsonProperty("short_name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
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
     *     The image
     */
    @JsonProperty("image")
    public Object getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    @JsonProperty("image")
    public void setImage(Object image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The homeVenueId
     */
    @JsonProperty("home_venue_id")
    public Object getHomeVenueId() {
        return homeVenueId;
    }

    /**
     * 
     * @param homeVenueId
     *     The home_venue_id
     */
    @JsonProperty("home_venue_id")
    public void setHomeVenueId(Object homeVenueId) {
        this.homeVenueId = homeVenueId;
    }

    /**
     * 
     * @return
     *     The slug
     */
    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    /**
     * 
     * @param slug
     *     The slug
     */
    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * 
     * @return
     *     The score
     */
    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The images
     */
    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The taxonomies
     */
    @JsonProperty("taxonomies")
    public List<Taxonomy_> getTaxonomies() {
        return taxonomies;
    }

    /**
     * 
     * @param taxonomies
     *     The taxonomies
     */
    @JsonProperty("taxonomies")
    public void setTaxonomies(List<Taxonomy_> taxonomies) {
        this.taxonomies = taxonomies;
    }

    /**
     * 
     * @return
     *     The hasUpcomingEvents
     */
    @JsonProperty("has_upcoming_events")
    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    /**
     * 
     * @param hasUpcomingEvents
     *     The has_upcoming_events
     */
    @JsonProperty("has_upcoming_events")
    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
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
     *     The genres
     */
    @JsonProperty("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     *     The genres
     */
    @JsonProperty("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * 
     * @return
     *     The primary
     */
    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    /**
     * 
     * @param primary
     *     The primary
     */
    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
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
