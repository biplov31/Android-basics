package com.example.apiintegrationapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class CatFactResponse {
    // Gson helps us map JSON string to a CatFactResponse object
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String content;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
