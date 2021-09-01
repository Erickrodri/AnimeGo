
package com.dap.animego.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Anime {

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

    /**
     * No args constructor for use in serialization
     * 
     */
    public Anime() {
    }

    /**
     * 
     * @param id
     * @param genres
     * @param name
     * @param imageUrl
     */
    public Anime(String imageUrl, String id, String name, List<Genre> genres) {
        super();
        this.imageUrl = imageUrl;
        this.id = id;
        this.name = name;
        this.genres = genres;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String photo) {
        this.imageUrl = photo;
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

}
