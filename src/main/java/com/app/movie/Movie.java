package com.app.movie;

import com.app.person.JobTitle;
import com.app.person.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "releaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Column(name = "title")
    private String title;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "runtimeMinutes")
    private Integer runtimeMinutes;

    private Map<Person,JobTitle> people;
    private List<Genre> genres;
    private List<String> imagesObjectIds;

    public Movie() {
    }
}
