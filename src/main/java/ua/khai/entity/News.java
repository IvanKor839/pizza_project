package ua.khai.entity;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity(name="news")
public class News extends BaseEntity{

    private String name;

    private String description;

    private String picture;

    public News() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
