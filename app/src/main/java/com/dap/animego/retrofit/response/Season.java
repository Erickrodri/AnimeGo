
package com.dap.animego.retrofit.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season {

    @SerializedName("firstEmission")
    @Expose
    private String firstEmission;
    @SerializedName("lastEmission")
    @Expose
    private String lastEmission;
    @SerializedName("chapters")
    @Expose
    private List<Chapter> chapters = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("seasonal")
    @Expose
    private String seasonal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Season() {
    }

    /**
     * 
     * @param id
     * @param seasonal
     * @param chapters
     * @param lastEmission
     * @param name
     * @param firstEmission
     */
    public Season(String firstEmission, String lastEmission, List<Chapter> chapters, String id, String name, String seasonal) {
        super();
        this.firstEmission = firstEmission;
        this.lastEmission = lastEmission;
        this.chapters = chapters;
        this.id = id;
        this.name = name;
        this.seasonal = seasonal;
    }

    public String getFirstEmission() {
        return firstEmission;
    }

    public void setFirstEmission(String firstEmission) {
        this.firstEmission = firstEmission;
    }

    public String getLastEmission() {
        return lastEmission;
    }

    public void setLastEmission(String lastEmission) {
        this.lastEmission = lastEmission;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
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

    public String getSeasonal() {
        return seasonal;
    }

    public void setSeasonal(String seasonal) {
        this.seasonal = seasonal;
    }

}
