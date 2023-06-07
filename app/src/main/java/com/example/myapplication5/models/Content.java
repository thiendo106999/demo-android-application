package com.example.myapplication5.models;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Content {
    @SerializedName("id")
    Integer id;

    String title;
    String desc;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String url;
    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", url='" + url + '\'' +
                '}';
    }
}
