
package com.dap.animego.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;
    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseAuth() {
    }

    /**
     *
     * @param username
     * @param token
     * @param photoUrl
     */
    public ResponseAuth(String username, String photoUrl, String token) {
        super();
        this.username = username;
        this.photoUrl = photoUrl;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}