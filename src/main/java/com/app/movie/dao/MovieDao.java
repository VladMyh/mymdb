package com.app.movie.dao;

import com.app.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public interface MovieDao {
    ArrayList<Movie> getAllMovies();
    Movie addOrUpdateMovie(Movie movie);
    void deleteMovie(String id);
    long getNumberOfFilms();
    Movie getMovieById(String id);
    List<Movie> getPage(int pageNunber, int itemsPerPage);
    List<Movie> searchMovies(String query);

    //TODO: finish paging method
    //TODO: add method to load images into db
}
