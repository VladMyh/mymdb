package com.app.movie;

import com.app.person.JobTitle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    @Indexed
    private String ic;
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
    private Date releaseDate;
    private String title;
    private String synopsis;
    private Integer runtimeMinutes;
    private Map<String, JobTitle> crew;
    private List<Genre> genres;
    private List<String> imagesObjectIds;

    public Movie() {
    }

    public Movie(String id){
        this.id = id;
    }

    public Movie(Date releaseDate, String title, String synopsis,
                 Integer runtimeMinutes, Map<String, JobTitle> crew,
                 List<Genre> genres, List<String> imagesObjectIds) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.synopsis = synopsis;
        this.runtimeMinutes = runtimeMinutes;
        this.crew = crew;
        this.genres = genres;
        this.imagesObjectIds = imagesObjectIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public Map<String, JobTitle> getCrew() {
        return crew;
    }

    public void setCrew(Map<String, JobTitle> crew) {
        this.crew = crew;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<String> getImagesObjectIds() {
        return imagesObjectIds;
    }

    public void setImagesObjectIds(List<String> imagesObjectIds) {
        this.imagesObjectIds = imagesObjectIds;
    }
}
