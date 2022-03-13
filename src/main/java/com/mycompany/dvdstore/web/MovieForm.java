package com.mycompany.dvdstore.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {
    @NotBlank @Size(max=20)
    String title;
    @NotBlank
    String genre;
    long id;
    @Size(max=255)
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
