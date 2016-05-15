package com.app.movie.service;

import com.app.movie.Movie;

import java.util.ArrayList;

public interface MovieService {
    ArrayList<Movie> getAllMovies();
    Movie addOrUpdateMovie(Movie movie);
    void deleteMovie(Long id);
    long getNumberOfFilms();
    Movie getMovieById(String id);
}
