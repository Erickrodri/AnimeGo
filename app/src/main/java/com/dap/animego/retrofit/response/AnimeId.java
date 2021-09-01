
package com.dap.animego.retrofit.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeId {

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("season")
    @Expose
    private List<Season> season = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AnimeId() {
    }

    /**
     * 
     * @param id
     * @param v
     * @param season
     * @param genres
     * @param imageUrl
     * @param name
     */
    public AnimeId(String imageUrl, String id, String name, List<Genre> genres, List<Season> season, Integer v) {
        super();
        this.imageUrl = imageUrl;
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.season = season;
        this.v = v;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Season> getSeason() {
        return season;
    }

    public void setSeason(List<Season> season) {
        this.season = season;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
