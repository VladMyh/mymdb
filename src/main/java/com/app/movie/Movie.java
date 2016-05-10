package com.app.movie;

import com.app.actor.Actor;
import com.app.director.Director;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Movie {

    @Id
    private Long id;

    @Indexed
    private String ic;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date releaseDate;

    private String title;
    private String synopsis;
    private Integer runtimeMinutes;
    private List<Director> directors;
    private List<Actor> actors;
    private List<Genre> genres;
    private List<String> imagesObjectIds;

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Integer runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
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

    public Movie(Long id, String title, String synopsis, Date releaseDate, Integer runtimeMinutes,
                 List<Director> directors, List<Actor> actors, List<Genre> genres, List<String> imagesObjectIds) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.runtimeMinutes = runtimeMinutes;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
        this.imagesObjectIds = imagesObjectIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!id.equals(movie.id)) return false;
        if (!title.equals(movie.title)) return false;
        if (synopsis != null ? !synopsis.equals(movie.synopsis) : movie.synopsis != null) return false;
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null) return false;
        if (runtimeMinutes != null ? !runtimeMinutes.equals(movie.runtimeMinutes) : movie.runtimeMinutes != null)
            return false;
        if (directors != null ? !directors.equals(movie.directors) : movie.directors != null) return false;
        if (actors != null ? !actors.equals(movie.actors) : movie.actors != null) return false;
        if (genres != null ? !genres.equals(movie.genres) : movie.genres != null) return false;
        return imagesObjectIds != null ? imagesObjectIds.equals(movie.imagesObjectIds) : movie.imagesObjectIds == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (runtimeMinutes != null ? runtimeMinutes.hashCode() : 0);
        result = 31 * result + (directors != null ? directors.hashCode() : 0);
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (imagesObjectIds != null ? imagesObjectIds.hashCode() : 0);
        return result;
    }
}
