package com.app.movie.service;

import com.app.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public interface MovieService {
    ArrayList<Movie> getAllMovies();
    Movie addOrUpdateMovie(Movie movie);
    void deleteMovie(String id);
    long getNumberOfFilms();
    Movie getMovieById(String id);
    List<Movie> getPage(int pageNunber, int itemsPerPage);
    List<Movie> searchMovies(String query);
}
