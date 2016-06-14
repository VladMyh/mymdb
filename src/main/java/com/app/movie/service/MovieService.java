package com.app.movie.service;

import com.app.movie.Movie;
import com.app.person.JobTitle;

import java.util.ArrayList;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies(int pageNum, int pageSize);
    Movie addOrUpdateMovie(Movie movie);
    void deleteMovie(String id);
    long getNumberOfFilms();
    Movie getMovieById(String id);
    List<Movie> getPage(int pageNum, int pageSize, String searchQuery);
    List<Movie> searchMovies(String query);
    List<Movie> getLastFour();
    void addPersonToMovie(String movieId, String personId, JobTitle title);
    void deletePersonToMovie(String movieId, String personId, JobTitle title);
}
